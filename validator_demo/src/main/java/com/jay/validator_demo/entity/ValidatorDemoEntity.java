package com.jay.validator_demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 基于javax.validation.constrains包
 * @see <a href="https://javaee.github.io/javaee-spec/javadocs/javax/validation/constraints/package-frame.html">java(TM)EE 8</a>
 * 该类只描述和使用了部分注解的作用，具体还是要看官网上的文档。
 */

@Data
@ToString
public class ValidatorDemoEntity implements Serializable {
    private Long id;
    /*
     * 判断不为空串且不为空
     */
    @NotBlank(message = "名字不可为空")
    private String name;

    /**
     * 判断年龄是否为0-100之间，注意：是可以为空的，因为没有加@NotNull注解
     * tips:空值被认为是有效的
     */
    @Min(0)
    @Max(100)
    private Integer age;

    /**
     * 邮箱格式
     * tips:空值被认为是有效的
     */
    @Email(message = "不为邮箱格式")
    private String email;

    /**
     * 字符、数组、集合、Map等长度判断
     * tips:空值被认为是有效的
     */
    @Size(min = 0, max = 100, message = "长度不在0和100之间")
    private String strLength;

    /**
     * 不可为控股
     */
    @NotNull
    private String noNull;

    /**
     * 必须为空
     */
    @Null
    private String mustNull;

    /**
     * 支持的类：
     * java.util.Date
     * java.util.Calendar
     * java.time.Instant
     * java.time.LocalDate
     * java.time.LocalDateTime
     * java.time.LocalTime
     * java.time.MonthDay
     * java.time.OffsetDateTime
     * java.time.OffsetTime
     * java.time.Year
     * java.time.YearMonth
     * java.time.ZonedDateTime
     * java.time.chrono.HijrahDate
     * java.time.chrono.JapaneseDate
     * java.time.chrono.MinguoDate
     * java.time.chrono.ThaiBuddhistDate
     * 时间为未来时间
     * tips:空值被认为是有效的
     */
    @Future(message = "时间必须为今天之后")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime futureTime;

    /**
     * 时间必须是当下时间以后的时间
     * tips:空值被认为是有效的
     */
    @FutureOrPresent(message = "时间必须是当下时间以后的时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime futureOrPersentTime;

    /**
     * 必须为false
     * tips:空值被认为是有效的
     */
    @AssertFalse
    private Boolean mustFalse;

    /**
     * 必须为true
     * tips:空值被认为是有效的
     */
    @AssertTrue
    private Boolean mustTrue;

    /**
     * 支持的类
     * BigDecimal
     * BigInteger
     * CharSequence
     * byte, short, int, long, and their respective wrappers
     * tips:空值被认为是有效的
     */
    @DecimalMax(value = "100.00")
    @DecimalMin(value = "0.00")
    private BigDecimal creditCard;

    /**
     * 支持的类上同
     * tips:空值被认为是有效的
     * integer： 整数位数
     * fraction: 小数位数
     * 输入的数字必须在小于100且小数位数大于3
     * tips:空值被认为是有效的
     */
    @Digits(integer = 100, fraction = 3)
    private BigDecimal myCard;
}