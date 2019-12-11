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
        try {
            // 发送消息到mq
            messageService.sendMessage(content);
            // 修改消息状态为已发送
            this.updateSendFlag(message.getMsgId(), 1);
        } catch (Exception e){
            e.printStackTrace();
        }
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
}
