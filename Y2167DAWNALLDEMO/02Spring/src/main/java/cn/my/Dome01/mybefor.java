package cn.my.Dome01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by 浅笑 on 2018/3/12.
 */
public class mybefor {

    public void before() throws Throwable {
        System.out.println("前置通知方法");
    }
    public void afterReturing(){
        System.out.println("后置通知方法");
    }
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕通知方法,目标方法执行之前");
        Object result=pjp.proceed();
        System.out.println("环绕通知方法,目标方法执行之后");
        return ((String)result).toLowerCase();
    }
    public void throwing(){
        System.out.println("异常通知方法");
    }
    public void afinally(){
        System.out.println("最终通知方法");
    }
}
