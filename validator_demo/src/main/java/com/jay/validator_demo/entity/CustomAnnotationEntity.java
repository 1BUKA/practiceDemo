package com.jay.validator_demo.entity;

import com.jay.validator_demo.validator.annotion.IsIDCard;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 自定义注解类示例
 */
@Data
@ToString
public class CustomAnnotationEntity implements Serializable {
    @IsIDCard
    private String idCard;
}
