package io.seata.samples.sca.customer.feign;

import io.seata.samples.sca.common.domain.TbUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description userService 远程服务调用
 * @Author ZhangJJ
 * @Since 2022/4/24 19:11
 **/
@FeignClient(value = "sca-provider")
@RequestMapping("/provider/api")
public interface UserService {
    @PostMapping("/add")
    public void add(TbUser tbUser);
}
