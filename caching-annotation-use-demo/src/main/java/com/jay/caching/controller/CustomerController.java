package com.jay.caching.controller;

import com.jay.caching.Service.CustomerService;
import com.jay.caching.model.Customer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description 缓存注解调用
 * @Author ZhangJJ
 * @Since 2022/4/18 4:01
 **/
@RestController
public class CustomerController {
    @Resource
    CustomerService customerService;

    @RequestMapping("/customerinfo/{value}")
    public List customerInfomation(@PathVariable Integer value) throws InterruptedException {
        Thread.sleep(5 * 1000);
        return customerService.getList(value);
    }

    @RequestMapping("/customer")
    public List customer() throws InterruptedException {
        List list = customerService.getList(1);
        Object o = (Customer)list.get(0);
        return customerService.getList((Customer) o);
    }

    @RequestMapping("/customers")
    public List customers() throws InterruptedException {
        List<Customer> list = customerService.getList(1);
        return customerService.getList(list);
    }
}
