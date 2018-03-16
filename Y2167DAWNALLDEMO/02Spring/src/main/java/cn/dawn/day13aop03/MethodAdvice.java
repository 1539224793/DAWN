package cn.dawn.day13aop03;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by Dawn on 2018/3/8.
 */
/*环绕增强需要实现MethodInterceptor这个接口*/
public class MethodAdvice implements MethodInterceptor {
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("前置增强");
        /*它可以使前置增强和后置增强分开，同时实现前置和后置*/
        methodInvocation.proceed();
        System.out.println("后置增强");
        return null;
    }
}
