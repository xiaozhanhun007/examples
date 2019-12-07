package com.zzp.consumer.msg.handlers;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zzp.consumer.entity.TCoupon;
import org.apache.commons.lang3.StringUtils;

/**
 * @Description 优惠券handler
 * @Author Garyzeng
 * @since 2019.12.07
 **/
public class CouponHandler implements BaseHandler {

    public boolean hasHandle(String msg) {
        JSONObject msgJson = JSON.parseObject(msg);
        String type = msgJson.getString("type");
        if (StringUtils.isNotBlank(type) && type.equals("Coupon")) {
            return true;
        }
        return false;
    }

    public void handler(String msg) {
        if (this.hasHandle(msg)) {
            JSONObject msgJson = JSON.parseObject(msg);
            JSONObject dataJson = msgJson.getJSONObject("data");
            TCoupon coupon = JSON.parseObject(dataJson.toJSONString(), TCoupon.class);
            System.out.println(coupon.getCouponName());
        }
    }
}
