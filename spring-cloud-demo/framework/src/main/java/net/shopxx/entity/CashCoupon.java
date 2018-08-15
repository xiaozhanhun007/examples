/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 * FileId: pjJ4UgFBNBSqnN31Gn/ju1G5fn5q+larpRaym0k10DE=
 */
package net.shopxx.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import net.shopxx.entity.BaseEntity.BaseView;
import net.shopxx.plugin.CouponPromotionPlugin;
import net.shopxx.plugin.CouponPromotionPlugin.CouponAttribute;

/**
 * Entity - 代金券来源
 * 
 * @author SHOP++ Team
 * @version 6.1
 */
@Entity
public class CashCoupon extends BaseEntity<Long> {

	private static final long serialVersionUID = -7907808728349149722L;
	
	/**
	 * 类型
	 */
	public enum Type {
		register,//注册
		firstlogin,//第一次登录
		voucher,//兑换
		shopcomplete,//购物完成
		shopping,//购物
		refund//退货
	}

	@NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
	private Member member;
	
	@JsonView(BaseView.class)
	@NotNull
	@Column(nullable = false)
	private CashCoupon.Type type;

	@JsonView(BaseView.class)
	@Column(columnDefinition="decimal(15,2) default 0.0") 
	private BigDecimal amount;
	
	@JsonView(BaseView.class)
	@Column(name = "description", nullable = true, length = 500)
	private String description;
	
	@Column(name = "businessId", nullable = true)
	private Long businessId;

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public CashCoupon.Type getType() {
		return type;
	}

	public void setType(CashCoupon.Type type) {
		this.type = type;
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

	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

}