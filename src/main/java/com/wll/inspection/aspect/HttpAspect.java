package com.wll.inspection.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author GO FOR IT
 */

@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(com.wll.inspection.aspect.HttpAspect.class);

    @Pointcut("execution(public * com.wll.inspection.controller.*.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("url={}", request.getRequestURL());
        logger.info("url={}", request.getMethod());
        //获得类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + "joins" + joinPoint.getSignature().getName());
    }

    @After("log()")
    public void doAfter() {
        logger.info("after");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {

    }

}
