package com.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by Administrator on 5/21/2014.
 */
@Aspect
public abstract class abstractAop {

    public static final String TRACE_TEMPLATE="Join point : {} - State: {} - Status: {}";

    @Pointcut(value = "within(com.springapp..*)")
    public void inServiceLayer(){

    }

}
