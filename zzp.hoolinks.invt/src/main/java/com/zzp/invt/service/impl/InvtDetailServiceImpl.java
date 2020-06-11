package com.zzp.invt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zzp.invt.entity.InvtDetail;
import com.zzp.invt.entity.InvtHead;
import com.zzp.invt.mapper.InvtDetailMapper;
import com.zzp.invt.service.IInvtDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzp.invt.service.IInvtHeadService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 核注清单表体 服务实现类
 * </p>
 *
 * @author Garyzeng
 * @since 2020-06-07
 */
@Service
public class InvtDetailServiceImpl extends ServiceImpl<InvtDetailMapper, InvtDetail> implements IInvtDetailService {

    @Autowired
    private InvtDetailMapper invtDetailMapper;

    @Autowired
    private IInvtHeadService invtHeadService;

    public List<InvtDetail> listInvtDetails(Integer invtHeadId) {
        return this.listInvtDetails(invtHeadId, null);
    }

    public List<InvtDetail> listInvtDetails(Integer invtHeadId, Integer putrecSeqno) {
        LambdaQueryWrapper<InvtDetail> queryWrapper = new LambdaQueryWrapper<InvtDetail>();
        queryWrapper.eq(InvtDetail::getInvtHeadId, invtHeadId);
        if (putrecSeqno != null) {
            queryWrapper.eq(InvtDetail::getPutrecSeqno, putrecSeqno);
        }
        List<InvtDetail> invtDetails = invtDetailMapper.selectList(queryWrapper);
        return invtDetails;
    }

    @Override
    public List<InvtDetail> listInvtDetails(String etpsInnerInvtNo, String companyUid, Integer putrecSeqno) {
        InvtHead invtHead = invtHeadService.getInvtHeadByInnerInvtNo(etpsInnerInvtNo, companyUid);
        if (invtHead == null) {
            return null;
        }
        return this.listInvtDetails(invtHead.getId(), putrecSeqno);
    }

    @Override
    public String filterPutrecSeqnos(List<InvtDetail> invtDetails) {
        if (CollectionUtils.isEmpty(invtDetails)) {
            return null;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < invtDetails.size(); i++) {
            sb.append(invtDetails.get(i).getPutrecSeqno() + ",");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));

        return sb.toString();
    }
}
