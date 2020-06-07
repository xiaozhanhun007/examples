package com.zzp.invt.service;

import com.zzp.invt.entity.InvtDetail;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 核注清单表体 服务类
 * </p>
 *
 * @author Garyzeng
 * @since 2020-06-07
 */
public interface IInvtDetailService extends IService<InvtDetail> {

    /**
     * 根据表头Id查询标体列表
     * @param invtHeadId 核注清单表头id
     * @return List<InvtDetail>
     */
    List<InvtDetail> listInvtDetails(Integer invtHeadId);

}
