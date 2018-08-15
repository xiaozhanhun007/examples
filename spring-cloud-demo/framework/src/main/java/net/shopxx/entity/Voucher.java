package net.shopxx.entity;

import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.Date;

/**
 * 兑换券
 */
@Entity
@Table(name = "voucher")
public class Voucher extends BaseEntity<Long> {
    /**
     * 兑换券类型
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private VoucherType voucherType;

    /**
     * 券码
     */
    @Column(nullable = true,length = 11, unique = true)
    private String bonusSn;
    /**
     * 编码
     */
    @Column(nullable = true,length = 11)
    private String bn;

    /**
     * 用户
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = true,foreignKey = @ForeignKey(name="none",value= ConstraintMode.NO_CONSTRAINT))
    private Member member;

    /**
     * 使用时间
     */
    private Date usedTime;

    /**
     * 关联订单
     */
//    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = true,foreignKey = @ForeignKey(name="none",value= ConstraintMode.NO_CONSTRAINT))
    private Order order;

    /**
     * 开始使用时间
     */
    private Date useStartDate;
    /**
     * 结束使用时间
     */
    private Date useEndDate;

    /**
     * 状态
     */
    public enum Status {

        /**
         * 未使用
         */
        NOT_USED("未使用"),

        /**
         * 已使用
         */
        USED("已使用"),
        /**
         * 未生效
         */
        NOT_EFFECTIVE("未生效"),
        /**
         * 已过期
         */
        OVERDUE("已过期"),
        /**
         * 已删除
         */
        DELETED("已删除");

        String text;

        Status(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public static Status getStatusByIndex(int index) {
            Status[] arr = Status.values();
            for(Status s : arr) {
                if(s.ordinal() == index) {
                    return s;
                }
            }
            return null;
        }
    }

    /**
     * 状态
     */
    @JsonView(BaseView.class)
    @Column(nullable = false)
    private Voucher.Status status;
    /**
     * 发放日期
     */
    private Date releaseDate;

    /**
     * 领卡人
     */
    @Length(max = 60)
    private String receiver;

    /**
     * 领卡人联系方式
     */
    @Length(max = 30)
    private String receiverPhone;

    /**
     * 领取日期
     */
    private Date receiveDate;
    /**
     * 单位名称
     */
    @Length(max = 200)
    private String organName;

    /**
     * 支付编码
     */
    @Transient
    private String paymentTransactionSn;

    public VoucherType getVoucherType() {
        return voucherType;
    }

    public void setVoucherType(VoucherType voucherType) {
        this.voucherType = voucherType;
    }

    public String getBonusSn() {
        return bonusSn;
    }

    public void setBonusSn(String bonusSn) {
        this.bonusSn = bonusSn;
    }

    public String getBn() {
        return bn;
    }

    public void setBn(String bn) {
        this.bn = bn;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Date getUsedTime() {
        return usedTime;
    }

    public void setUsedTime(Date usedTime) {
        this.usedTime = usedTime;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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

    public Status getStatus() {
        Date currDate = Calendar.getInstance().getTime();
        if(Status.NOT_USED == status) {
            if(currDate.getTime() < this.useStartDate.getTime()) {
                this.status = Status.NOT_EFFECTIVE;
            } else if(currDate.getTime() > this.useEndDate.getTime()) {
                this.status = Status.OVERDUE;
            }
        }
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public String getPaymentTransactionSn() {
        return paymentTransactionSn;
    }

    public void setPaymentTransactionSn(String paymentTransactionSn) {
        this.paymentTransactionSn = paymentTransactionSn;
    }
}
