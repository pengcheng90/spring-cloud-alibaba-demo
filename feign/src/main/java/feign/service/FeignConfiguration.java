package feign.service;

import feign.service.impl.EchoServiceFallback;
import org.springframework.context.annotation.Bean;

public class FeignConfiguration {

    /**
     * 加载EchoServiceFallbackBean
     * @return
     */
    @Bean
    public EchoServiceFallback echoServiceFallback() {
        return new EchoServiceFallback();
    }

}
