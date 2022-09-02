package com.peng.sentinel.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.peng.sentinel.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    /**
     * SentinelResource注解用来标识资源是否被限流、降级。上述例子上该注解的属性 'hello' 表示资源名
     * 更多参考：https://github.com/alibaba/Sentinel/wiki/%E6%B3%A8%E8%A7%A3%E6%94%AF%E6%8C%81
     * 还提供了其它额外的属性如 blockHandler，blockHandlerClass，fallback 用于表示限流或降级的操作
     */
    @SentinelResource(value = "hello", blockHandler = "exceptionHandler", fallback = "helloFallBack")
    @Override
    public String hello(String s) throws ParamFlowException {
        //抛出异常测试触发异常处理
//        throw new RuntimeException("test error"); // 测试 fallback
        throw new ParamFlowException("hello", "param error"); //测试 blockHandler
//        return "hello";
    }

    /**
     * fallback 函数签名与原函数一致或者多加一个 Throwable 类型的函数
     */
    public String helloFallBack(String s) {
        return "halo " + s;
    }

    /**
     * Block 异常处理函数，参数最后多一个 BlockException，其余与原函数一致.
     */
    public String exceptionHandler(String s, BlockException e) {
        e.printStackTrace();
        return "error " + s;
    }

}
