package com.transwrap.transwrap.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author: yml
 * @time: 2020/12/28
 */

@Aspect
@Component
public class LogRecode {
    private final Logger logger = LoggerFactory.getLogger(LogRecode.class);

    @Resource
    HttpServletRequest httpServletRequest;


    @Pointcut(value = "execution(* com.transwrap.transwrap.control.UserController.*.*(..))")
    private void control() {
    }

    @After(value = "control()")
    public void recodeInLog() {
        logger.warn(" user has been access");
    }

    @AfterThrowing(throwing = "ex", value = "execution(* com.transwrap.transwrap.*.*(..))", argNames = "ex,joinPoint")
    public void recodeTheException(Exception ex, JoinPoint joinPoint) {
        logger.error(joinPoint.getSignature().getName() + " : error occur : ", ex);
    }

    @Around(value = "execution(* com.transwrap.transwrap.control.FileController.*(..))")
    public Object recodeTheFileOperator(ProceedingJoinPoint pjp) throws Throwable {
        Signature signature = pjp.getSignature();
        logger.info(" method name "+signature.getName()+"; and the caller user "+ httpServletRequest.getRemoteAddr());
        return pjp.proceed();
    }

}
