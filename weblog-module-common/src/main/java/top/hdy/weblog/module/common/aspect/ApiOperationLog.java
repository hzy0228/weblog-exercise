package top.hdy.weblog.module.common.aspect;

import java.lang.annotation.*;

/**
 * @Author: Hao-ZY
 * @Date: 2024/4/30 16:38
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface ApiOperationLog {

    /**
     * API 功能描述
     *
     * @return
     */
    String description() default "";
}
