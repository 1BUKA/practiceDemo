package io.seata.samples.sca.provider.api;

import io.seata.samples.sca.common.domain.TbUser;
import io.seata.samples.sca.provider.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description 暴露给userService 给openfeign调用的
 * @Author ZhangJJ
 * @Since 2022/4/24 19:08
 **/
@RestController
@RequestMapping("/provider/api")
public class UserServiceController {
    @Resource
    private UserService userService;

    @PostMapping("/add")
    public void add(@RequestBody TbUser tbUser){
        userService.add(tbUser);
    }
}
