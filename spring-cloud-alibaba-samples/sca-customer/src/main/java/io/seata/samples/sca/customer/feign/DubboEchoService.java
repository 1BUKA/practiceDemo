package io.seata.samples.sca.customer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description dubboEcho远程调用服务
 * @Author ZhangJJ
 * @Since 2022/4/24 19:15
 **/
@FeignClient(value = "sca-provider")
@RequestMapping("/provider/api")
public interface DubboEchoService {
    @PostMapping("/echo")
    public String echo(String name);
}
