package cn.dawn.day04aop.aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by Dawn on 2018/3/5.
 */
/*后置增强*/
public class LoggerAfter implements AfterReturningAdvice {
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("===============after==================");
    }
}
