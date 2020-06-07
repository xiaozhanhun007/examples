package com.zzp.invt.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Garyzeng
 * @since 2020-06-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("dcl_ent_bill_head")
public class EntBillHead implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 企业编号
     */
    private String companyUid;

    /**
     * 企业编号
     */
    private String companyCode;

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
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 分组UID
     */
    private String groupUid;

    /**
     * 分组名称
     */
    private String groupName;

    /**
     * 发票号/合同号
     */
    private String invoiceNo;

    /**
     * 发票日期
     */
    private LocalDateTime invoiceDate;

    /**
     * 料件成品标记/物料类别 I-料件；E-成品
     */
    private String imgExgMark;

    /**
     * 平台单证号 TDL+年月日+6位流水号
     */
    private String citDocNo;

    /**
     * 单据编号
     */
    private String docNo;

    /**
     * 单据日期
     */
    private LocalDateTime docDate;

    /**
     * 单据类型/进出口标志,I-进口计划单，E-出口计划单
     */
    private String docType;

    /**
     * 手册编号
     */
    private String emlNo;

    /**
     * 收货人编号
     */
    private String consigneeNo;

    /**
     * 收货人名称
     */
    private String consigneeName;

    /**
     * 发货人编号
     */
    private String shipperNo;

    /**
     * 发货人名称
     */
    private String shipperName;

    /**
     * 运输方式CODE
     */
    private String trafMode;

    /**
     * 运输方式NAME
     */
    private String trafModeName;

    /**
     * 运输工具名称
     */
    private String trafName;

    /**
     * 包装种类code
     */
    private String wrapType;

    /**
     * 包装种类name
     */
    private String wrapTypeName;

    /**
     * 监管方式代码
     */
    private String tradeMode;

    /**
     * 监管方式名称
     */
    private String tradeModeName;

    /**
     * 启运国code
     */
    private String fromCountry;

    /**
     * 启运国name
     */
    private String fromCountryName;

    /**
     * 启运港code
     */
    private String fromPort;

    /**
     * 启运港name
     */
    private String fromPortName;

    /**
     * 目的国code
     */
    private String toCountry;

    /**
     * 目的国name
     */
    private String toCountryName;

    /**
     * 目的港/经停港 code
     */
    private String toPort;

    /**
     * 目的港/经停港 name
     */
    private String toPortName;

    /**
     * 提运单号
     */
    private String billNo;

    /**
     * 提运日期
     */
    private LocalDateTime billDate;

    /**
     * 成交方式code
     */
    private String transMode;

    /**
     * 成交方式name
     */
    private String transModeName;

    /**
     * 成交备注
     */
    private String transMemo;

    /**
     * 付款方式
     */
    private String payWay;

    /**
     * 付款备注
     */
    private String payWayMemo;

    /**
     * 进出口日期
     */
    private LocalDateTime ieDate;

    /**
     * 进出口岸 code
     */
    private String iePort;

    /**
     * 进出口岸 name
     */
    private String iePortName;

    /**
     * 进境关别code
     */
    private String ieCustomCode;

    /**
     * 进境关别name
     */
    private String ieCustomName;

    /**
     * 仓库(仓位)编号
     */
    private String wareHouseNo;

    /**
     * 备注
     */
    private String memo;

    /**
     * 贸易国CODE
     */
    private String tradePlaceCode;

    /**
     * 贸易国
     */
    private String tradePlaceName;

    /**
     * 航次号
     */
    private String transportVoyageNo;

    /**
     * 主管海关CODE
     */
    private String masterCuscd;

    /**
     * 主管海关NAME
     */
    private String masterCuscdName;

    /**
     * 报关标志 1-报关，2-非报关
     */
    private Integer billFlag;

    /**
     * 报关类型 1-关联报关，2-对应报关
     */
    private Integer billType;

    /**
     * 客户供应商code
     */
    private String customerSupplierCode;

    /**
     * 客户供应商name
     */
    private String customerSupplierName;

    /**
     * 是否复审 
     */
    private Boolean isReview;

    /**
     * 复审时间
     */
    private LocalDateTime reviewDate;

    /**
     * 复审人id
     */
    private String reviewManId;

    /**
     * 复审人name
     */
    private String reviewManName;

    /**
     * 报关单备注
     */
    private String billMemo;

    /**
     * 申报地海关code
     */
    private String customCode;

    /**
     * 申报地海关name
     */
    private String customName;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 分单编号
     */
    private String houseBillNo;

    /**
     * 扩展字段1
     */
    private String extField1;

    /**
     * 扩展字段2
     */
    private String extField2;

    /**
     * 扩展字段3
     */
    private String extField3;

    /**
     * 扩展字段4
     */
    private String extField4;

    /**
     * 扩展字段5
     */
    private String extField5;

    /**
     * 扩展字段6
     */
    private String extField6;

    /**
     * 扩展字段7
     */
    private String extField7;

    /**
     * 扩展字段8
     */
    private String extField8;

    /**
     * 扩展字段9
     */
    private String extField9;

    /**
     * 扩展字段10
     */
    private String extField10;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 关联备案编号
     */
    private String rltPutrecNo;

    /**
     * 申报表编号
     */
    private String applyNo;

    /**
     * 原始计划单号
     */
    private String plannedOrderNo;


}
