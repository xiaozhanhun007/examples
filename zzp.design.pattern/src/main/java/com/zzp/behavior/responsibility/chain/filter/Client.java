package com.zzp.behavior.responsibility.chain.filter;

/**
 * @Description 测试客户端
 * @Author karyzeng
 * @since 2020.07.23
 **/
public class Client {

    public static void main(String[] args) {
        Filter urlFilter = new UrlFilter(null);
        Filter loginFilter = new LoginFilter(urlFilter);
        loginFilter.doFilter();
    }

}
