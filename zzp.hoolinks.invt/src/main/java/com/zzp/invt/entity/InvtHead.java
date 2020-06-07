package com.zzp.invt.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 核注清单表头
 * </p>
 *
 * @author Garyzeng
 * @since 2020-06-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("dcl_invt_head")
public class InvtHead implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 企业编码
     */
    private String companyCode;

    /**
     * 企业UID
     */
    private String companyUid;

    /**
     * 创建人id
     */
    private String createrId;

    /**
     * 创建人
     */
    private String createrName;

    /**
     * 修改人id
     */
    private String updaterId;

    /**
     * 创建人
     */
    private String updaterName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 分组UID
     */
    private String groupUid;

    /**
     * 分组名称
     */
    private String groupName;

    /**
     * 清单预录入统一编号
     */
    private String seqNo;

    /**
     * 清单编号
     */
    private String bondInvtNo;

    /**
     * 审批状态
     */
    private Integer apprStatus;

    /**
     * 审批备注
     */
    private String ediResult;

    /**
     * 修改变更次数
     */
    private Integer chgTmsCnt;

    /**
     * 备案编号
     */
    private String putrecNo;

    /**
     * 企业内部编号
     */
    private String etpsInnerInvtNo;

    /**
     * 经营企业社会信用代码
     */
    private String bizopEtpsSccd;

    /**
     * 经营企业编号
     */
    private String bizopEtpsno;

    /**
     * 经营企业名称
     */
    private String bizopEtpsNm;

    /**
     * 收发货企业社会信用代码
     */
    private String rvsngdEtpsSccd;

    /**
     * 收货企业编号
     */
    private String rcvgdEtpsNo;

    /**
     * 收货企业名称
     */
    private String rcvgdEtpsNm;

    /**
     * 申报企业社会信用代码
     */
    private String dclEtpsSccd;

    /**
     * 申报企业编号
     */
    private String dclEtpsNo;

    /**
     * 申报企业名称
     */
    private String dclEtpsNm;

    /**
     * 录入企业社会信用代码
     */
    private String inputCreditCode;

    /**
     * 录入企业编号
     */
    private String inputCode;

    /**
     * 录入单位名称
     */
    private String inputName;

    /**
     * 清单申报时间
     */
    private Date invtDclTime;

    /**
     * 报关单申报时间
     */
    private Date entryDclTime;

    /**
     * 对应报关单编号
     */
    private String entryNo;

    /**
     * 对应报关单申报单位社会统一信用代码
     */
    private String corrEntryDclEtpsSccd;

    /**
     * 对应报关单申报单位代码
     */
    private String corrEntryDclEtpsNo;

    /**
     * 对应报关单申报单位名称
     */
    private String corrEntryDclEtpsNm;

    /**
     * 关联清单编号
     */
    private String rltInvtNo;

    /**
     * 关联备案编号
     */
    private String rltPutrecNo;

    /**
     * 关联报关单编号
     */
    private String rltEntryNo;

    /**
     * 关联报关单经营企业社会信用代码
     */
    private String rltEntryBizopEtpsSccd;

    /**
     * 关联报关单经营企业编号
     */
    private String rltEntryBizopEtpsNo;

    /**
     * 关联报关单经营企业名称
     */
    private String rltEntryBizopEtpsNm;

    /**
     * 关联报关单收发货单位社会统一信用代码
     */
    private String rltEntryRvsngdEtpsSccd;

    /**
     * 关联报关单海关收发货单位编码
     */
    private String rltEntryRcvgdEtpsNo;

    /**
     * 关联报关单收发货单位名称
     */
    private String rltEntryRcvgdEtpsNm;

    /**
     * 关联报关单申报单位社会统一信用代码
     */
    private String rltEntryDclEtpsSccd;

    /**
     * 关联报关单海关申报单位编码
     */
    private String rltEntryDclEtpsNm;

    /**
     * 关联报关单申报单位名称
     */
    private String rltEntryDclEtpsNo;

    /**
     * 境外收发货人代码
     */
    private String overseasConsignNo;

    /**
     * 境外收发货人名称
     */
    private String overseasConsignName;

    /**
     * 进出口口岸代码
     */
    private String impexpPortcd;

    /**
     * 申报地关区代码
     */
    private String dclPlcCuscd;

    /**
     * 进出口标记代码
     */
    private String impexpMarkcd;

    /**
     * 成品料件标识(I: 料件， E:成品)对应 ImgExgMark
     */
    private String mtpckEndprdMarkcd;

    /**
     * 监管方式代码
     */
    private String supvModecd;

    /**
     * 运输方式代码
     */
    private String trspModecd;

    /**
     * 运输工具名称
     */
    private String trafName;

    /**
     * 申请表编号
     */
    private String applyNo;

    /**
     * 流转类型
     */
    private String listType;

    /**
     * 是否报关标志
     */
    private String dclcusFlag;

    /**
     * 报关类型代码
     */
    private String dclcusTypecd;

    /**
     * 预核扣时间
     */
    private Date prevdTime;

    /**
     * 正式核扣时间
     */
    private Date formalVrfdedTime;

    /**
     * 清单进出卡口状态代码
     */
    private String invtIochkptStucd;

    /**
     * 核扣标记代码
     */
    private String vrfdedMarkcd;

    /**
     * 申报人IC卡号
     */
    private String icCardNo;

    /**
     * 清单状态
     */
    private String listStat;

    /**
     * 清单类型
     */
    private String invtType;

    /**
     * 报关单状态
     */
    private String entryStucd;

    /**
     * 报关单类型
     */
    private String decType;

    /**
     * 备注
     */
    private String rmk;

    /**
     * 入库时间
     */
    private Date addTime;

    /**
     * 起运运抵国别代码
     */
    private String stshipTrsarvNatCd;

    /**
     * 核放单生成标志代码
     */
    private String passportUsedTypeCd;

    /**
     * 备用字段1
     */
    private String param1;

    /**
     * 备用字段2
     */
    private String param2;

    /**
     * 备用字段3
     */
    private String param3;

    /**
     * 备用字段4
     */
    private String param4;

    /**
     * 录入日期
     */
    private Date inputTime;

    /**
     * 主管海关
     */
    private String masterCuscd;

    /**
     * 业务选项
     */
    private Integer bizType;

    /**
     * 成交方式
     */
    private String transMode;

    /**
     * 成交备注
     */
    private String transMemo;

    /**
     * 启运港
     */
    private String fromPort;

    /**
     * 目的国
     */
    private String toCountry;

    /**
     * 目的港
     */
    private String toPort;

    /**
     * 提运单号
     */
    private String billNo;

    /**
     * 提运日期
     */
    private Date billDate;

    /**
     * 包装方式
     */
    private String wrapType;

    /**
     * 发票号
     */
    private String invoiceNo;

    /**
     * 数据状态
     */
    private Integer dataStat;

    /**
     * 申报类型
     */
    private Integer dclTypecd;

    /**
     * 平台单证号
     */
    private String citDocNo;

    /**
     * 检查人id
     */
    private Integer checkerId;

    /**
     * 检查人
     */
    private String checkerName;

    /**
     * 检查时间
     */
    private Date checkTime;

    /**
     * 复审人id
     */
    private Integer auditorId;

    /**
     * 复审人
     */
    private String auditorName;

    /**
     * 复审时间
     */
    private Date auditTime;

    /**
     * 报关单统一编号
     */
    private String decSeqNo;

    /**
     * 进出口日期
     */
    private Date ieDate;

    /**
     * 航次号
     */
    private String voyNo;

    /**
     * 经停港/指运港
     */
    private String distinatePort;

    /**
     * 入/离境口岸
     */
    private String entyPortCode;

    /**
     * 客户供应商海关编码
     */
    private String suppliersCustomsCode;

    /**
     * 计划单单据编号
     */
    private String entBillDocNo;

    /**
     * 核注清单预设值id
     */
    private Integer invtPreId;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 进出口口岸名称
     */
    private String impexpPortcdName;

    /**
     * 申报地关区代码名称
     */
    private String dclPlcCuscdName;

    /**
     * 监管方式名称
     */
    private String supvModecdName;

    /**
     * 运输方式名称
     */
    private String trspModecdName;

    /**
     * 起运运抵国别名称
     */
    private String stshipTrsarvNatCdName;

    /**
     * 核放单生成标志名称
     */
    private String passportUsedTypeCdName;

    /**
     * 主管海关名称
     */
    private String masterCuscdName;

    /**
     * 成交方式名称
     */
    private String transModeName;

    /**
     * 启运港名称
     */
    private String fromPortName;

    /**
     * 目的国名称
     */
    private String toCountryName;

    /**
     * 目的港名称
     */
    private String toPortName;

    /**
     * 包装方式名称
     */
    private String wrapTypeName;

    /**
     * 经停港/指运港名称
     */
    private String distinatePortName;

    /**
     * 入/离境口岸名称
     */
    private String entyPortName;

    /**
     * 扩展栏位1
     */
    private String extField1;

    /**
     * 扩展栏位2
     */
    private String extField2;

    /**
     * 扩展栏位3
     */
    private String extField3;

    /**
     * 扩展栏位4
     */
    private String extField4;

    /**
     * 扩展栏位5
     */
    private String extField5;

    /**
     * 扩展栏位6
     */
    private String extField6;

    /**
     * 扩展栏位7
     */
    private String extField7;

    /**
     * 扩展栏位8
     */
    private String extField8;

    /**
     * 扩展栏位9
     */
    private String extField9;

    /**
     * 扩展栏位10
     */
    private String extField10;

    /**
     * 客户供应商名称
     */
    private String suppliersName;

    /**
     * 客户供应商统一信用代码
     */
    private String suppliersCreditCode;

    /**
     * 报关单草稿备注
     */
    private String entryDclDraftRmk;

    /**
     * 贸易国代码
     */
    private String tradePlaceCode;

    /**
     * 贸易国名称
     */
    private String tradePlaceName;

    /**
     * 来源系统
     */
    private String sourcePlatform;

    /**
     * 归并类型，1表示一对一，2表示归并，默认1
     */
    private Integer mergeType;

    /**
     * 1表示生成，2表示不生成
     */
    private Integer dclCreateFlag;

    /**
     * 发送尊网标记，1表示已发送，0表示未发送，默认为1
     */
    private Integer sendZwFlag;

    /**
     * ZW平台单证号
     */
    private String docNo;

    /**
     * 发送尊网次数，默认为0
     */
    private Integer sendZwCount;


}
