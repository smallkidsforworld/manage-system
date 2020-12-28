package com.transwrap.transwrap.aspect;

import com.transwrap.transwrap.utils.TimeUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description: 测试testError.大致分为启动前，产生错误后，以及最终的执行完成后
 * @author: yml
 * @time: 2020/10/30
 */


@Deprecated
public class LogInterceptorTest {
    private final Logger logger = LoggerFactory.getLogger(LogInterceptorTest.class);

    @Pointcut(value = "execution(* com.transwrap.transwrap.control..*.*(..))")
    private void test() {
    }

    @Before(value = "test()")
    public void beforeCallMethod() {
        logger.info(TimeUtil.getCurrentDay() + " log start : " + TimeUtil.getCurrentTime());
    }

    @AfterThrowing(throwing = "exception", value = "test()")
    public void throwException(Throwable exception) {
        logger.info("the method has exception : " + exception + "  occur time is " +
                TimeUtil.getDayWithTime());
    }

    @After(value = "test()")
    public void AfterCallMethod() {
        logger.info("log ended : " + TimeUtil.getDayWithTime());
    }

    @Around(value = "test()")
    public Object test(ProceedingJoinPoint process) throws Throwable {
        Object[] args = process.getArgs();
        logger.info("methodName "+ process.getSignature().getName());
        logger.info("Object Name "+  process.getTarget().getClass().getName());
        return process.proceed(args);
    }
}
