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
import net.shopxx.plugin.CouponPromotionPlugin;
import net.shopxx.plugin.CouponPromotionPlugin.CouponAttribute;

/**
 * Entity - 代金券使用记录
 * 
 * @author SHOP++ Team
 * @version 6.1
 */
@Entity
public class CashCouponUse extends BaseEntity<Long> {

	private static final long serialVersionUID = -7907808728349149722L;
	
	@NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
	private Member member;

	@Column(columnDefinition="decimal(15,2) default 0.0") 
	private BigDecimal amount;
	

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}