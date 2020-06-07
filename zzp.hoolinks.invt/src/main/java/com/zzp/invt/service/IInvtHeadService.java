package com.zzp.invt.service;

import com.zzp.invt.entity.InvtHead;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.InputStream;

/**
 * <p>
 * 核注清单表头 服务类
 * </p>
 *
 * @author Garyzeng
 * @since 2020-06-07
 */
public interface IInvtHeadService extends IService<InvtHead> {

    void createInvtHeadSQL();

    void createInvtDetailSQL();

    String getResourceConfig(InputStream resourceInputStream) throws Exception;

    /**
     * 根据清单编号和企业UID来查询核注清单表头
     * @param bondInvtNo
     * @param companyUid
     * @return
     */
    InvtHead getInvtHead(String bondInvtNo, String companyUid);

}
