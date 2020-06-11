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
     * 根据表头Id查询表体列表
     * @param invtHeadId 核注清单表头id
     * @return List<InvtDetail>
     */
    List<InvtDetail> listInvtDetails(Integer invtHeadId);

    /**
     * 根据表头id和备案序号来查询表体列表
     * @param invtHeadId
     * @param putrecSeqno
     * @return
     */
    List<InvtDetail> listInvtDetails(Integer invtHeadId, Integer putrecSeqno);

    /**
     * 根据表头企业内部编号、企业UID和备案序号来查询表体列表
     * @param etpsInnerInvtNo 表头企业内部编号
     * @param companyUid 企业UID
     * @param putrecSeqno 备案序号
     * @return
     */
    List<InvtDetail> listInvtDetails(String etpsInnerInvtNo, String companyUid, Integer putrecSeqno);

    /**
     * 过滤得到表体的备案序号字符串，格式如1,2,3
     * @param invtDetails
     * @return
     */
    String filterPutrecSeqnos(List<InvtDetail> invtDetails);

}
