package cn.dawn.day20aspectjxml;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by Dawn on 2018/3/12.
 */
public class MyAspectJ {
    /*最后增强，无论是否出现异常都会执行*/
    public void myAfter(){
        System.out.println("最终增强");
    }
    /*后置增强*/
    public void myAfterReturning(){
        System.out.println("后置增强");
    }
    /*前置增强*/
    public void myBefore(){
        System.out.println("前置增强");
    }
    /*前置增强，这种写法可以一会调用出切点表达式，在console打印出来：当然xml文件中另外需要配置一道*/
    public void myBefore1(JoinPoint jp){
        System.out.println("前置通知方法jp = " + jp);
    }
    /*异常增强*/
    public void myAfterThrowing(){
        System.out.println("异常增强");
    }
    /*环绕增强*/
    public void myAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕增强前");
        pjp.proceed();
        System.out.println("环绕增强后");
    }

}
