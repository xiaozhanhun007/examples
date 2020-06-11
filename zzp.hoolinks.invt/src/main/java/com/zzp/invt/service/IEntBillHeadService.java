package com.zzp.invt.service;

import com.zzp.invt.entity.EntBillHead;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Garyzeng
 * @since 2020-06-07
 */
public interface IEntBillHeadService extends IService<EntBillHead> {

    /**
     * 根据企业UID和计划单单据编号来查询计划单表头
     * @param companyUid
     * @param docNo
     * @return
     */
    EntBillHead getEntBillHead(String companyUid, String docNo);

}
