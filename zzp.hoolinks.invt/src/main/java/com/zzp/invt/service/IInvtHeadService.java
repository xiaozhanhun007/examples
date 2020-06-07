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

    String getResourceConfig(InputStream resourceInputStream) throws Exception;

}
