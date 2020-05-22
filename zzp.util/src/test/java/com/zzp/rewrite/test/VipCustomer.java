package com.zzp.rewrite.test;

/**
 * @Description vip客户类
 * @Author karyzeng
 * @since 2020.05.21
 **/
public class VipCustomer extends Customer{

    public String isVip(String customerName) {
        return "否";
    }

    public Integer isVip1(Integer vipSize) {
        return 1;
    }

    public Integer isVip1(int customerName) {
        return 2;
    }


}
