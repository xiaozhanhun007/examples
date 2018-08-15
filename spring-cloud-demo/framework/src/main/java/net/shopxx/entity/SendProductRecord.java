package net.shopxx.entity;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


/**
 * Entity - 买赠记录
 *
 */
@Entity
public class SendProductRecord extends BaseEntity<Long> {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Member member;

    /**
     * 类型
     */
    public enum Type {
        VOUCHER("兑换"), //兑换
        SHOP_COMPLETE("购物完成"),//购物完成
        CANCEL("取消订单");//退货;

        private String text;

        Type(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

    }
    @JsonView(BaseView.class)
    @NotNull
    @Column(nullable = false)
    private Type type;

    @Column(name = "businessId", nullable = true)
    private Long businessId;

    @JsonView(BaseView.class)
    @Column(columnDefinition="decimal(15,2) default 0.0")
    private BigDecimal amount;

    @JsonView(BaseView.class)
    @Column(name = "description", nullable = true, length = 500)
    private String description;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
