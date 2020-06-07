package com.zzp.invt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzp.invt.entity.InvtDetail;
import com.zzp.invt.mapper.InvtDetailMapper;
import com.zzp.invt.service.IInvtDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

    public List<InvtDetail> listInvtDetails(Integer invtHeadId) {
        QueryWrapper<InvtDetail> queryWrapper = new QueryWrapper<InvtDetail>();
        queryWrapper.eq("invt_head_id", invtHeadId);
        List<InvtDetail> invtDetails = invtDetailMapper.selectList(queryWrapper);
        return invtDetails;
    }
}
