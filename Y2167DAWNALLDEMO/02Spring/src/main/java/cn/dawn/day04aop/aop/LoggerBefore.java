package cn.dawn.day04aop.aop;


import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by Dawn on 2018/3/5.
 */
/*前置增强*/
public class LoggerBefore implements MethodBeforeAdvice {
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("日志记录");
    }
}
