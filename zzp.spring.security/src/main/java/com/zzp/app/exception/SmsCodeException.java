package com.zzp.app.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 手机验证码自定义异常
 *
 * @author karyzeng
 * @since 2019.07.06
 */
public class SmsCodeException extends AuthenticationException {

    public SmsCodeException(String message) {
        super(message);
    }

}
