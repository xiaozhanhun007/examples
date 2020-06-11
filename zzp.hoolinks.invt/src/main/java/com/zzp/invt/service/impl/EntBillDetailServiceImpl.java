package com.zzp.invt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzp.invt.entity.EntBillDetail;
import com.zzp.invt.mapper.EntBillDetailMapper;
import com.zzp.invt.service.IEntBillDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Garyzeng
 * @since 2020-06-07
 */
@Service
public class EntBillDetailServiceImpl extends ServiceImpl<EntBillDetailMapper, EntBillDetail> implements IEntBillDetailService {

    @Autowired
    private EntBillDetailMapper entBillDetailMapper;

    public List<EntBillDetail> listEntBillDetails(Integer entBillHeadId) {
        QueryWrapper<EntBillDetail> queryWrapper = new QueryWrapper<EntBillDetail>();
        queryWrapper.eq("ent_bill_head_id", entBillHeadId);
        List<EntBillDetail> entBillDetails = entBillDetailMapper.selectList(queryWrapper);
        return entBillDetails;
    }
}
