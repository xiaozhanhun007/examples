package com.zzp.provider.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzp.base.mq.msg.vo.Message;
import com.zzp.provider.entity.TSendMessage;
import com.zzp.provider.mapper.TSendMessageMapper;
import com.zzp.provider.service.IMessageService;
import com.zzp.provider.service.ITSendMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <p>
 * 发送的消息 服务实现类
 * </p>
 *
 * @author zzp
 * @since 2019-12-12
 */
@Service
public class TSendMessageServiceImpl extends ServiceImpl<TSendMessageMapper, TSendMessage> implements ITSendMessageService {

    @Autowired
    private IMessageService messageService;

    @Transactional
    public void saveMessageAndSendMq(Message message) {
        // 保存消息表示未发送到mq
        String content = JSON.toJSONString(message);
        TSendMessage sendMessage = new TSendMessage();
        sendMessage.setMsgId(message.getMsgId());
        sendMessage.setType(message.getType());
        sendMessage.setContent(content);
        sendMessage.setCreateTime(new Date());
        this.save(sendMessage);
        this.sendMqAndUpdateSendFlag(sendMessage);
    }

    @Transactional
    public void updateSendFlag(String msgId, Integer sendFlag) {
        QueryWrapper<TSendMessage> queryWrapper = new QueryWrapper<TSendMessage>();
        queryWrapper.eq("msg_id", msgId);
        TSendMessage oldSendMessage = this.getOne(queryWrapper);
        if (oldSendMessage != null) {
            oldSendMessage.setSendFlag(sendFlag);
            this.updateById(oldSendMessage);
        }
    }

    public void sendMqAndUpdateSendFlag(TSendMessage sendMessage) {
        try {
            // catch这两个操作的原因，失败之后不至于数据会回滚，
            // 如果发送失败，后续定时器会定时检查发送状态为未发送的消息，再次将其发送到mq
            // 失败情况如下：
            // 1、发送mq失败，则不会执行修改状态操作
            // 2、发送mq成功，但是修改状态失败（状态还是未发送），
            // 如果mq消息已经被消费者消费了，后续定时器再次发送该消息的话，消费者对消息支持幂等，所以不会重复消费

            // 发送消息到mq
            messageService.sendMessage(sendMessage.getContent());
            // 修改消息状态为已发送
            this.updateSendFlag(sendMessage.getMsgId(), 1);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}