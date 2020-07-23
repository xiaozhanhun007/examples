package com.zzp.behavior.responsibility.chain.filter;

/**
 * @Description Url过滤器
 * @Author karyzeng
 * @since 2020.07.23
 **/
public class UrlFilter implements Filter{

    private Filter nextFilter;

    public UrlFilter(Filter nextFilter) {
        this.nextFilter = nextFilter;
    }

    public void doFilter() {
        System.out.println("执行URL过滤");
        if (nextFilter != null) {
            nextFilter.doFilter();
        }
    }
}
