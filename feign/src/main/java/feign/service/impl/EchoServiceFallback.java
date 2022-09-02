package feign.service.impl;

import feign.service.EchoService;
import org.springframework.web.bind.annotation.PathVariable;

public class EchoServiceFallback implements EchoService {

    @Override
    public String echo(@PathVariable String str) {
        return "echo fallback";
    }

}
