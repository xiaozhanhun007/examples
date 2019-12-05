package com.zzp.behavior.responsibility.chain;

import java.text.SimpleDateFormat;

/**
 * @Description url handler测试
 * @Author Garyzeng
 * @since 2019.12.05
 **/
public class Text {

    public static void main(String[] args) {
        try {
            // 创建url上下文
            UrlContext context = new UrlContext();
            String dateStr = "2019-12-05 12:05:06";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            context.setCreateTime(sdf.parse(dateStr));
            context.setUrl("www.baidu.com/ab");

            // 创建url规则handler
            UrlRuleHandler urlRuleHandler = new UrlRuleHandler();
            // 创建url超时handler
            UrlTimeOutHandler urlTimeOutHandler = new UrlTimeOutHandler();
            // 将超时handler放到规则handler之后
            urlRuleHandler.setNextHandler(urlTimeOutHandler);
            // 开始验证上下文
            urlRuleHandler.apply(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
