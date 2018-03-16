package cn.dawn.day19aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by Dawn on 2018/3/12.
 */
@Aspect
public class MyAspectJ {

    /*单独拎出来的注解，一会下面用他的方法名可以调用到他的切点表达式*/
    @Pointcut(value = "execution(* *..day19aspectj.*.select(..))")
    public void select(){

    }
    @Pointcut(value = "execution(* *..day19aspectj.*.update(..))")
    public void update(){

    }

    /*后置增强*/
    @AfterReturning("execution(* *..day19aspectj.*.select(..))")
    public void myAfterReturning(){
        System.out.println("后置增强");
    }

    /*前置增强*/
    @Before("execution(* *..day19aspectj.*.insert(..))")
    public void myBefore(){
        System.out.println("前置增强");
    }

    /*异常增强*/
    @AfterThrowing("execution(* *..day19aspectj.*.update(..))")
    public void myAfterThrowing(){
        System.out.println("异常增强");
    }

    /*最终增强*//*
    @After("execution(* *..day19aspectj.*.update(..))||execution(* *..day19aspectj.*.select(..))")
    public void myafter(){
        System.out.println("我是最终增强");
    }*/

    /*最终增强*/
    @After("update()||select()")
    public void myafter(){
        System.out.println("我是最终增强");
    }

    /*环绕增强*/
    @Around("execution(* *..day19aspectj.*.insert(..))")
    public void myAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕增强前");
        pjp.proceed();
        System.out.println("环绕增强后");
    }
}
