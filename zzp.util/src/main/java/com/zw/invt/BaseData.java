package com.zw.invt;

/**
 * @Description 基础数据
 * @Author karyzeng
 * @since 2020.06.05
 **/
public class BaseData {

    /**
     * 企业十位编码
     */
    private String companyCode;

    /**
     * 企业Uid
     */
    private String companyUid;

    /**
     * 创建人id
     */
    private Integer creatorId;

    /**
     * 创建人id名称
     */
    private String creatorName;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyUid() {
        return companyUid;
    }

    public void setCompanyUid(String companyUid) {
        this.companyUid = companyUid;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }
}
