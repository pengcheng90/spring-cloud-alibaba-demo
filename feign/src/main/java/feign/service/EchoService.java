package feign.service;

import feign.service.impl.EchoServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * FeignClient注解只能加到interface上
 */
@FeignClient(name = "service-provider", fallback = EchoServiceFallback.class, configuration = FeignConfiguration.class)
public interface EchoService {

    /**
     * 需要加GetMapping注解
     * 通过GET:http://service-provider/echo/{str} 访问该service方法
     *
     * @return
     */
    @GetMapping("/echo/{string}")
    String echo(@PathVariable String string);

}
