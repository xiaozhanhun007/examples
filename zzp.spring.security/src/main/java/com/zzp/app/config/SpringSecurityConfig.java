package com.zzp.app.config;

import com.zzp.app.sms.SmsAuthenticationConfig;
import com.zzp.app.sms.SmsCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;

/**
 * @Description TODO
 * @Author karyzeng
 * @since 2019.07.03
 **/
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SmsCodeFilter smsCodeFilter;

    @Autowired
    private SmsAuthenticationConfig smsAuthenticationConfig;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SessionStrategy sessionStrategy(){
        return new HttpSessionSessionStrategy();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(smsCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
//                .loginPage("/login.htm.")// 用户名密码登录
                .loginPage("/smsCodeLogin.html")// 短信验证码登录
                .loginProcessingUrl("/login")
                .and()
                    .authorizeRequests()
                    .antMatchers("/login.html", "/smsCodeLogin.html", "/smsCode/get").permitAll()
                    .anyRequest()
                    .authenticated()
                .and()
                    .sessionManagement() // session失效后的跳转地址
                    .invalidSessionUrl("")
//                    .maximumSessions(1)// 表示同一个账号同一时刻最多能登录1个，但是只能对用户名密码登录有效
                .and()
                    .csrf().disable()
                .apply(smsAuthenticationConfig);
    }
}
