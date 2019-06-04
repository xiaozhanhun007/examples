package com.util.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @Description 异常转换为字符串
 * @Author zzp
 * @since 2019.06.04
 **/
public class ExceptionPrintUtil {

    /**
     * 将异常信息转换成字符串
     *
     * @param t 异常
     *
     * @return String
     */
    public static String printStackTraceToString(Throwable t) {
        try (StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw, true);) {
            t.printStackTrace(pw);
            String stackTraceString = sw.getBuffer().toString();
            return stackTraceString;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
