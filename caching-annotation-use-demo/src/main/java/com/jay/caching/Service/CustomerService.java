package com.jay.caching.Service;

import com.jay.caching.model.Customer;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @Description 注解演示操作
 * @Author ZhangJJ
 * @Since 2022/4/18 4:52
 **/
@Service
@CacheConfig(cacheNames = "customer")
public class CustomerService {

    @Caching(
            cacheable = {
                    @Cacheable(/*value = "customer",*/)
            }
            ,put = {
                    @CachePut(/*value = "customer",*/)
            }
    )
    public List getList(Integer value) {
//        Customer charlie_puth = new Customer(8237, "Charlie Puth", "Current A/c", 450000.00);
        Integer itemKey = Math.random() > 0.1f? 2 : 1;

        Customer charlie_puth = new Customer(itemKey, "Charlie Puth", "Current A/c", 450000.00);

        List detail = Arrays.asList(charlie_puth,
                new Customer(Math.random() > 0.1f? 2 : 1, "Andrew Flintoff", "Saving A/c", 210089.00)
        );
        return detail;
    }
    /**
     * @Description 解决不同个数的相同对象，如何用SpEL表示
     * @Author ZhangJJ
     * @Since 2022/4/18
     **/
    @Cacheable(key = "#customer")
    public List getList(Customer customer) throws InterruptedException {
        Thread.sleep(5*1000);
        System.out.println(customer);
        return Arrays.asList(customer);
    }

    @Cacheable(key = "#p0")
    public List getList(List<Customer> customers) throws InterruptedException {
        Thread.sleep(5*1000);
        customers.forEach(item->{
            System.out.println(item);
        });
        List list = getList(customers, 1);
        return list;
    }

    @Cacheable(key = "#p0")
    public List getList(List<Customer> customers,Integer value) throws InterruptedException {
        Thread.sleep(5*1000);
        customers.forEach(item->{
            System.out.println(item);
        });
        return customers;
    }
}
