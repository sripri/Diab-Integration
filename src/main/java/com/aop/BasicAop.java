package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 5/21/2014.
 */
@Aspect
@Component
public class BasicAop extends  abstractAop {

    Logger log= LoggerFactory.getLogger(this.getClass());
    @Pointcut("execution(* *Controller*(..))")
    public void controllerMethods(){};

    @Around("inServiceLayer() && controllerMethods()")
    public Object interceptExecution(ProceedingJoinPoint pjp) throws  Throwable
    {
        String op=pjp.getTarget().getClass().getSimpleName()+"."+pjp.getSignature().getName();
        log.debug(TRACE_TEMPLATE,new Object[]{op, "RECEIVED","INITIATING",0});
        Object output=null;
        try{
            output=pjp.proceed();
            log.debug(" Completed call .....");
        }catch(Throwable t){
            log.error(" Error occurred ... {}",t);
        }
        return output;
    }

}
