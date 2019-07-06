package com.zzp.app.sms;

import com.zzp.app.exception.SmsCodeException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 手机验证码过滤器
 *
 * @author karyzeng
 * @since 2019.07.06
 */
@Component
public class SmsCodeFilter extends OncePerRequestFilter {

    @Autowired
    private SessionStrategy sessionStrategy;

    public final static String SESSION_KEY_SMS_CODE = "SESSION_KEY_SMS_CODE";

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        if (StringUtils.equalsIgnoreCase("/login/mobile", httpServletRequest.getRequestURI())
                && StringUtils.equalsIgnoreCase(httpServletRequest.getMethod(), "post")) {
            try {
                validateSmsCode(new ServletWebRequest(httpServletRequest));
            } catch (SmsCodeException e) {
                return;
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private void validateSmsCode(ServletWebRequest servletWebRequest) throws ServletRequestBindingException {
        String smsCodeInRequest = ServletRequestUtils.getStringParameter(servletWebRequest.getRequest(), "smsCode");
        String mobile = ServletRequestUtils.getStringParameter(servletWebRequest.getRequest(), "mobile");
        SmsCode codeInSession = (SmsCode) sessionStrategy.getAttribute(servletWebRequest, SESSION_KEY_SMS_CODE + mobile);

        if (StringUtils.isBlank(smsCodeInRequest)) {
            throw new SmsCodeException("验证码不能为空！");
        }
        if (codeInSession == null) {
            throw new SmsCodeException("验证码不存在，请重新发送！");
        }
        if (codeInSession.isExpire()) {
            sessionStrategy.removeAttribute(servletWebRequest, SESSION_KEY_SMS_CODE + mobile);
            throw new SmsCodeException("验证码已过期，请重新发送！");
        }
        if (!StringUtils.equalsIgnoreCase(codeInSession.getCode(), smsCodeInRequest)) {
            throw new SmsCodeException("验证码不正确！");
        }
        sessionStrategy.removeAttribute(servletWebRequest, SESSION_KEY_SMS_CODE + mobile);

    }
}
