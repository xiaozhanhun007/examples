package com.zzp.invt.entity;

import java.math.BigDecimal;
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
@TableName("dcl_ent_bill_detail")
public class EntBillDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 企业UID
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

    private Integer entBillHeadId;

    /**
     * 核注清单平台单证号
     */
    private String citDocNo;

    /**
     * 序号
     */
    private Integer sequence;

    /**
     * 料号
     */
    private String itemNo;

    /**
     * 企业商品名称/货物名称
     */
    private String itemName;

    /**
     * 规格
     */
    private String gmodel;

    /**
     * 料件/成品标识(I：料件，E：成品)
     */
    private String itemFlag;

    /**
     * 计量单位code
     */
    private String unit;

    /**
     * 单位名称
     */
    private String unitName;

    /**
     * 数量
     */
    private BigDecimal qty;

    /**
     * 净重
     */
    private BigDecimal netWt;

    /**
     * 毛重
     */
    private BigDecimal grossWt;

    /**
     * 包装箱号/集装箱号
     */
    private String packBoxNo;

    /**
     * 件数
     */
    private Integer packQty;

    /**
     * ERP版本号
     */
    private String erpVersion;

    /**
     * 报关商品序号/归并料号
     */
    private String baseCommodityItemNo;

    /**
     * 申报数量
     */
    private BigDecimal declQty;

    /**
     * 申报单位
     */
    private String declUnit;

    /**
     * 申报单位name
     */
    private String declUnitName;

    /**
     * 申报币种/币制code
     */
    private String declCurr;

    /**
     * 申报币种/币制name
     */
    private String declCurrName;

    /**
     * 总价
     */
    private BigDecimal tradeTotal;

    /**
     * 法定数量
     */
    private BigDecimal qty1;

    /**
     * 法定单位code
     */
    private String unit1;

    /**
     * 法定单位name
     */
    private String unit1Name;

    /**
     * 法二数量
     */
    private BigDecimal qty2;

    /**
     * 法二单位code
     */
    private String unit2;

    /**
     * 法二单位name
     */
    private String unit2Name;

    /**
     * 单价
     */
    private BigDecimal unitPrice;

    /**
     * 申报单价
     */
    private BigDecimal declPrice;

    /**
     * 备注
     */
    private String memo;

    /**
     * 产销国（地区）
     */
    private String natcd;

    /**
     * 原产国code
     */
    private String orgCountryCode;

    /**
     * 原产国
     */
    private String orgCountry;

    /**
     * 原产地区code
     */
    private String origPlaceCode;

    /**
     * 原产地区name
     */
    private String origPlaceName;

    /**
     * 最终目的国code
     */
    private String endCountryCode;

    /**
     * 最终目的国name
     */
    private String endCountryName;

    /**
     * 境内目的地code
     */
    private String districtCode;

    /**
     * 境内目的地/境内货源地
     */
    private String districtName;

    /**
     * 目的地代码(出口)/产地代码(进口)
     */
    private String inspectionOriginCode;

    /**
     * 目的地(出口)/产地(进口)
     */
    private String inspectionOriginName;

    /**
     * 监管方式code
     */
    private String tradeMode;

    /**
     * 监管方式name
     */
    private String tradeModeName;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 海关版本号
     */
    private Integer cusVersion;

    /**
     * 箱号
     */
    private String boxNo;

    /**
     * 航次号/车次号
     */
    private String transportVoyageNo;

    /**
     * 申报要素
     */
    private String elementName;

    /**
     * 归并序号
     */
    private Integer itemSeqNo;

    /**
     * 商品序号
     */
    private Integer gdsSeqno;

    /**
     * 商品编码
     */
    private String hsCode;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品规格
     */
    private String productSpec;

    /**
     * 是否已转核注清单
     */
    private Boolean isTransformInvt;

    /**
     * 转核注清单时间
     */
    private LocalDateTime transformDate;

    /**
     * 转核注清单人id
     */
    private String transformManId;

    /**
     * 转核注清单人name
     */
    private String transformManName;

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

    private String applyTbSeqno;

    /**
     * 发票号码
     */
    private String invoiceNo;

    /**
     * 集装箱规格code
     */
    private String containerMdCode;

    /**
     * 集装箱规格name
     */
    private String containerMdName;


}
