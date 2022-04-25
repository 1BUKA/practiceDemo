package io.seata.samples.sca.provider.api;

import io.seata.samples.sca.provider.service.DubboEchoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 暴露DubboEchoService 给openfeign调用
 * @Author ZhangJJ
 * @Since 2022/4/24 19:17
 **/
@RestController
@RequestMapping("/provider/api")
public class DubboEchoServiceController {
    @Resource
    private DubboEchoService dubboEchoService;

    @PostMapping("/echo")
    public String echo(String name){
        String echo = dubboEchoService.echo(name);
        return echo;
    }

}
