package demo.zzp.app.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 防止重复提交注解
 * @author karyzeng 2018.03.11
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME) // 在运行时可以获取
@Target(value = {ElementType.METHOD, ElementType.TYPE}) // 作用到类，方法，接口上等
public @interface PreventRepetitionAnnotation {

}
