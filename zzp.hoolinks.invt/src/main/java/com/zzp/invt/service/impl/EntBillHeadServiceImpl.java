package com.zzp.invt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzp.invt.entity.EntBillHead;
import com.zzp.invt.mapper.EntBillHeadMapper;
import com.zzp.invt.service.IEntBillHeadService;
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
public class EntBillHeadServiceImpl extends ServiceImpl<EntBillHeadMapper, EntBillHead> implements IEntBillHeadService {

    @Autowired
    private EntBillHeadMapper entBillHeadMapper;

    public EntBillHead getEntBillHead(String companyUid, String docNo) {
        QueryWrapper<EntBillHead> queryWrapper = new QueryWrapper<EntBillHead>();
        queryWrapper.eq("company_uid", companyUid);
        queryWrapper.eq("doc_no", docNo);
        List<EntBillHead> entBillHeads = entBillHeadMapper.selectList(queryWrapper);
        if (entBillHeads == null || entBillHeads.size() <= 0) {
            return null;
        }
        return entBillHeads.get(0);
    }
}
