package net.shopxx.entity;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 兑换券类型
 */
@Entity
@Table(name = "vouchertype")
public class VoucherType extends BaseEntity<Long> {
    @Column(nullable = false, length = 100)
    private String name;//类型名称
    @Digits(integer = 10, fraction = 2)
    @Column(nullable = false,precision = 10, scale = 2)
    private BigDecimal money;//金额
    @Digits(integer = 10, fraction = 2)
    @Column(nullable = false,precision = 10, scale = 2)
    private BigDecimal shipping;//物流运费
    @Column(nullable = true, length = 2,columnDefinition = "TINYINT(2)")
    private Integer sendType;//发送类型
    private Date useStartDate;//开始使用时间
    private Date useEndDate;//结束使用时间
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false,updatable = false)
    private Product product;//关联商品

    /**
     * 兑换卡类型
     */
    public enum CardType {

        /**
         * 实物卡
         */
        P_CARD,
        /**
         * 电子卡
         */
        E_CARD;
    }
    /**
     * 兑换卡类型
     */
    @JsonView(BaseView.class)
    @Column(nullable = false)
    private CardType cardType;

    /**
     * 卡券数量
     */
    @Transient
    private Long quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getShipping() {
        return shipping;
    }

    public void setShipping(BigDecimal shipping) {
        this.shipping = shipping;
    }

    public Integer getSendType() {
        return sendType;
    }

    public void setSendType(Integer sendType) {
        this.sendType = sendType;
    }

    public Date getUseStartDate() {
        return useStartDate;
    }

    public void setUseStartDate(Date useStartDate) {
        this.useStartDate = useStartDate;
    }

    public Date getUseEndDate() {
        return useEndDate;
    }

    public void setUseEndDate(Date useEndDate) {
        this.useEndDate = useEndDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public String getStatusText() {
        String status = "正常";
        long current = System.currentTimeMillis();
        if(current < this.useStartDate.getTime()) {
            status = "未开始";
        } else if (this.useEndDate.getTime() < current) {
            status = "已结束";
        }

        return status;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
