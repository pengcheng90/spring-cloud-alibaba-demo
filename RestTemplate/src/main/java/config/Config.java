package config;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import com.ctc.wstx.util.ExceptionUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    /**
     * @SentinelRestTemplate 注解的属性支持限流(blockHandler, blockHandlerClass)和降级(fallback, fallbackClass)的处理。
     * 其中 blockHandler 或 fallback 属性对应的方法必须是对应 blockHandlerClass 或 fallbackClass 属性中的静态方法。
     * 该方法的参数跟返回值跟 org.springframework.http.client.ClientHttpRequestInterceptor#interceptor 方法一致，其中参数多出了一个 BlockException 参数用于获取 Sentinel 捕获的异常。
     *
     * @SentinelRestTemplate注解的限流(blockHandler, blockHandlerClass)和降级(fallback, fallbackClass)属性不强制填写。
     * 当使用 RestTemplate 调用被 Sentinel 熔断后，会返回 RestTemplate request block by sentinel 信息，或者也可以编写对应的方法自行处理返回信息。这里提供了 SentinelClientHttpResponse 用于构造返回信息
     */
    @Bean
    @SentinelRestTemplate(blockHandler = "handleException", blockHandlerClass = ExceptionUtil.class)
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
