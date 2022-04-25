package com.jay.validator_demo.validator.annotion;

import com.jay.validator_demo.validator.IsIDCardValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 自定义校验注解
 * 参考链接
 * @see <a href="https://zhuanlan.zhihu.com/p/356861814">知乎-自定义校验注解ConstraintValidator</a>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
@Constraint(validatedBy = IsIDCardValidator.class) // 指定我们自定义的校验类
public @interface IsIDCard {
    /**
     * 是否强制校验
     *
     * @return 是否强制校验的boolean值
     */
    boolean required() default true;

    /**
     * 校验不通过时的报错信息
     *
     * @return 校验不通过时的报错信息
     */
    String message() default "";

    /**
     * 将validator进行分类，不同的类group中会执行不同的validator操作
     *
     * @return validator的分类类型
     */
    Class<?>[] groups() default {};

    /**
     * 主要是针对bean，很少使用
     *
     * @return 负载
     */
    Class<? extends Payload>[] payload() default {};
}
