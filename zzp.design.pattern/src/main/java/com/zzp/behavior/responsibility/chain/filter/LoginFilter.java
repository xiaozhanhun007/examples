package com.zzp.behavior.responsibility.chain.filter;

/**
 * @Description TODO
 * @Author karyzeng
 * @since 2020.07.23
 **/
public class LoginFilter implements Filter{

    private Filter nextFilter;

    public LoginFilter(Filter nextFilter) {
        this.nextFilter = nextFilter;
    }

    public void doFilter() {
        System.out.println("执行登录验证过滤");
        if (nextFilter != null) {
            nextFilter.doFilter();
        }
    }
}
