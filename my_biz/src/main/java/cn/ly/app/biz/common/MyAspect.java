package cn.ly.app.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
    @Pointcut("execution(* cn.ly.app.biz..*.*(..))")
    public void globalPoint() {

    }

    @Before("globalPoint()")
    public void myBefore(JoinPoint joinPoint) {
        System.out.println("前置通知 ： " + joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "globalPoint()", returning = "ret")
    public void myAfterReturning(JoinPoint joinPoint, Object ret) {
        System.out.println("后置通知 ： " + joinPoint.getSignature().getName() + " , -->" + ret);
    }

    public void myAfter() {
        System.out.println("最终通知");
    }

    @AfterThrowing(value = "execution(* cn.ly.app.biz..*.*(..))", throwing = "e")
    public void myAfterThrowing(JoinPoint joinPoint, Throwable e) {
        System.out.println("抛出异常通知 ： " + e.getMessage());
    }

    @Around("globalPoint()")
    public void myAround(ProceedingJoinPoint pj) throws Throwable {
        System.out.println("前置通知 ： ");
        Object proceed = pj.proceed();
        System.out.println("后置通知 ： ");
    }
}