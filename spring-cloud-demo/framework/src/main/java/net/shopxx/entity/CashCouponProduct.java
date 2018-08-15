package net.shopxx.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 * Entity - 代金券商品
 *
 */
@Entity
public class CashCouponProduct extends BaseEntity<Long> {

    /**
     * 产品
     */
    @NotNull
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, unique = true)
    private Product product;

    /**
     * 状态
     */
    public enum Status {

        /**
         * 草稿
         */
        DRAFT("草稿"),
        /**
         * 待审核
         */
        WAIT_AUDIT("待审核"),
        /**
         * 审核不通过
         */
        NO_PASS("审核不通过"),
        /**
         * 上架
         */
        ON_SHELF("上架"),
        /**
         * 下架
         */
        OFF_SHELF("下架");
        String text;

        Status(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }

    /**
     * 状态
     */
    private Status status;
    /**
     * 审核意见
     */
    private String comment;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
