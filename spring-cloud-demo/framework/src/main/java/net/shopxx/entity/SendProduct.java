package net.shopxx.entity;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Entity - 买赠商品
 *
 */
@Entity
public class SendProduct extends BaseEntity<Long> {
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
    @JsonView(BaseView.class)
    @Column(nullable = false)
    private Status status;

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
}
