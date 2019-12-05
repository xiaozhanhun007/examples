package com.zzp.behavior.responsibility.chain;

/**
 * @Description url规则handler
 * @Author Garyzeng
 * @since 2019.12.05
 **/
public class UrlRuleHandler extends Handler {

    @Override
    public void apply(Context context) {
        UrlContext urlContext = (UrlContext) context;
        if (!urlContext.getUrl().contains("www")) {
            throw new RuntimeException("url不合法！");
        }
        if (this.nextHandler != null) {
            this.nextHandler.apply(context);
        }
    }
}
