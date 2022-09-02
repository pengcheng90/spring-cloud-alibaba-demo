package feign.controller;

import feign.service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * wegt http://127.0.0.1:10084/test/app-name 测试feign
 */
@RestController
public class FeignTestController {

    @Autowired
    private EchoService echoService;

    @GetMapping("/test/{string}")
    public String test(@PathVariable String string) {
        //会通过feign调用到服务提供者feign.controller.EchoController
        return "feign调用测试 " + echoService.echo(string);
    }
}