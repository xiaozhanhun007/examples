package com.zzp.invt.entity.vo;

/**
 * @Description 核注清单表体
 * @Author karyzeng
 * @since 2020.06.05
 **/
public class InvtDetailVo extends InvtHeadVo {

    /**
     * 核注清单表体数量
     */
    private Integer detailSize;

    public Integer getDetailSize() {
        return detailSize;
    }

    public void setDetailSize(Integer detailSize) {
        this.detailSize = detailSize;
    }
}
