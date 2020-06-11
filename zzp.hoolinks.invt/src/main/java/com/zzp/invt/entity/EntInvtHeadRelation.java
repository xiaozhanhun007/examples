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
@TableName("dcl_ent_invt_head_relation")
public class EntInvtHeadRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 计划单表头ID
     */
    private Integer entBillHeadId;

    /**
     * 核注清单表头ID
     */
    private Integer entInvtHeadId;

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

    /**
     * 版本号
     */
    private Integer version;


}
