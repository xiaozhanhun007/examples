package com.zzp.invt.service;

import com.zzp.invt.entity.EntBillDetail;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Garyzeng
 * @since 2020-06-07
 */
public interface IEntBillDetailService extends IService<EntBillDetail> {

    /**
     * 根据计划单表头id来查询计划单表体列表
     * @param entBillHeadId
     * @return
     */
    List<EntBillDetail> listEntBillDetails(Integer entBillHeadId);

}
