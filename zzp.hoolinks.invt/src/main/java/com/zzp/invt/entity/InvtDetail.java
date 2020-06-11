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
 * 核注清单表体
 * </p>
 *
 * @author Garyzeng
 * @since 2020-06-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("dcl_invt_detail")
public class InvtDetail implements Serializable {

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
     * 表头id
     */
    private Integer invtHeadId;

    /**
     * 包装箱号
     */
    private String packBoxNo;

    /**
     * 中心统一编号
     */
    private String seqNo;

    /**
     * 商品序号
     */
    private Integer gdsSeqno;

    /**
     * 备案序号(对应底账序号）
     */
    private Integer putrecSeqno;

    /**
     * 商品料号
     */
    private String gdsMtno;

    /**
     * 商品编码
     */
    private String gdecd;

    /**
     * 商品名称
     */
    private String gdsNm;

    /**
     * 商品规格型号
     */
    private String gdsSpcfModelDesc;

    /**
     * 申报计量单位
     */
    private String dclUnitcd;

    /**
     * 法定计量单位
     */
    private String lawfUnitcd;

    /**
     * 法定第二计量
     */
    private String secdLawfUnitcd;

    /**
     * 产销国(地区)
     */
    private String natcd;

    /**
     * 企业申报单价
     */
    private BigDecimal dclUprcAmt;

    /**
     * 企业申报总价
     */
    private BigDecimal dclTotalAmt;

    /**
     * 美元统计总金额
     */
    private BigDecimal usdStatTotalAmt;

    /**
     * 币制
     */
    private String dclCurrcd;

    /**
     * 法定数量
     */
    private BigDecimal lawfQty;

    /**
     * 第二法定数量
     */
    private BigDecimal secdLawfQty;

    /**
     * 重量比例因子
     */
    private BigDecimal wtSfVal;

    /**
     * 第一比例因子
     */
    private BigDecimal fstSfVal;

    /**
     * 第二比例因子
     */
    private BigDecimal secdSfVal;

    /**
     * 申报数量*
     */
    private BigDecimal dclQty;

    /**
     * 毛重
     */
    private BigDecimal grossWt;

    /**
     * 净重
     */
    private BigDecimal netWt;

    /**
     * 件数
     */
    private Integer packQty;

    /**
     * 用途代码*
     */
    private String useCd;

    /**
     * 征免方式
     */
    private String lvyrlfModecd;

    /**
     * 单耗版本号
     */
    private Integer ucnsVerno;

    /**
     * 报关单商品序号
     */
    private BigDecimal entryGdsSeqno;

    /**
     * 流转申报表序号
     */
    private BigDecimal applyTbSeqno;

    /**
     * 归类标志
     */
    private String clyMarkcd;

    /**
     * 入库时间
     */
    private LocalDateTime addTime;

    /**
     * 备注
     */
    private String rmk;

    /**
     * 最终目的国
     */
    private String destinationCountry;

    /**
     * 目的地代码
     */
    private String destCode;

    /**
     * 原产地
     */
    private String origPlaceCode;

    /**
     * 境内目的地/境内货源地
     */
    private String districtCode;

    /**
     * 币制转换汇率
     */
    private BigDecimal exchangeRate;

    /**
     * 转换金额
     */
    private BigDecimal conversionAmount;

    /**
     * 车次
     */
    private String trainNumber;

    /**
     * 集装箱号
     */
    private String contaNo;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 产销国(地区)名称
     */
    private String natcdName;

    /**
     * 币制名称
     */
    private String dclCurrcdName;

    /**
     * 征免方式名称
     */
    private String lvyrlfModecdName;

    /**
     * 归类标志名称
     */
    private String clyMarkcdName;

    /**
     * 最终目的国名称
     */
    private String destinationCountryName;

    /**
     * 目的地名称
     */
    private String destName;

    /**
     * 原产地名称
     */
    private String origPlaceName;

    /**
     * 境内目的地/境内货源地名称
     */
    private String districtName;

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
     * 自动备案序号
     */
    private Integer autoPutrecSeqno;

    /**
     * 申报计量单位名称
     */
    private String dclUnitcdName;

    /**
     * 法定计量单位名称
     */
    private String lawfUnitcdName;

    /**
     * 法定第二计量名称
     */
    private String secdLawfUnitcdName;

    /**
     * 申报要素JSON列表
     */
    private String declareElementJson;


}
