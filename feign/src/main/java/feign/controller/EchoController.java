package feign.controller;

import feign.service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作为服务提供者给feign测试
 */
@RestController
public class EchoController {

    @Autowired
    private EchoService echoService;

    @GetMapping("/echo/{string}")
    public String echo(@PathVariable String string) {
        System.out.println("被调用了");
        return "被调用了";
    }
}