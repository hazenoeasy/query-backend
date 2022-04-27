package project.database.forum.common.aop;

import java.lang.annotation.*;

/**
 * @author Yuh Z
 * @date 12/15/21
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
    String module() default "";
    String operator() default "";
}
