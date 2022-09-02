package com.peng.sentinel;

import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.peng.sentinel.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/hello")
    public String hello() throws ParamFlowException {
        return testService.hello("test");
    }

}