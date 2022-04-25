package com.jay.validator_demo.validator;

import com.jay.validator_demo.validator.annotion.IsIDCard;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 注解实现
 *参考链接
 * @see <a href="https://zhuanlan.zhihu.com/p/356861814">知乎-自定义校验注解ConstraintValidator</a>
 */
public class IsIDCardValidator implements ConstraintValidator<IsIDCard, String> {
   // 是否强制校验
   private boolean required;

   @Override
   public void initialize(IsIDCard constraintAnnotation) {
      this.required = constraintAnnotation.required();
   }

   @Override
   public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
      if (required) {
         //true为校验通过， false为校验不通过
         // 这里只是简单的正则校验
         Pattern IdCard = Pattern.compile("\\d{17}[\\d|x|X]|\\d{15}");
         Matcher IdCardNumber = IdCard.matcher(name);//截取身份证号
         return IdCardNumber.find();//判断true
      }
      return false;
   }
}
