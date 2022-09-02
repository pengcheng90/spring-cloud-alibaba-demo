package com.peng.sentinel.service;

import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;

public interface TestService {

    String hello(String s) throws ParamFlowException;
}
