package com.zw.invt;

/**
 * @Description 核注清单
 * @Author karyzeng
 * @since 2020.06.05
 **/
public class InvtHead {

    /**
     * 核注清单表头id
     */
    private Integer id;

    /**
     * 计划单号
     */
    private String entBillNo;

    /**
     * 平台单证号
     */
    private String citDocNo;

    /**
     * 平台单证号
     */
    private String bondInvtNo;

    /**
     * 企业十位编码
     */
    private String companyCode;

    /**
     * 企业Uid
     */
    private String companyUid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEntBillNo() {
        return entBillNo;
    }

    public void setEntBillNo(String entBillNo) {
        this.entBillNo = entBillNo;
    }

    public String getCitDocNo() {
        return citDocNo;
    }

    public void setCitDocNo(String citDocNo) {
        this.citDocNo = citDocNo;
    }

    public String getBondInvtNo() {
        return bondInvtNo;
    }

    public void setBondInvtNo(String bondInvtNo) {
        this.bondInvtNo = bondInvtNo;
    }

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
}
