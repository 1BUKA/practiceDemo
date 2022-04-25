package com.jay.caching.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 实体类
 * @Author ZhangJJ
 * @Since 2022/4/18 4:00
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private int accountno;
    private String customername;
    private String accounttype;
    private double balance;
}
