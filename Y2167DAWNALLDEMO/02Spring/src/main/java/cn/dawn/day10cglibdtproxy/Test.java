package cn.dawn.day10cglibdtproxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Dawn on 2018/3/8.
 */
public class Test {
    public static void main(String[] args) {
        //模板
        final SomeServiceImpl service=new SomeServiceImpl();
        //cglib动态代理
        Enhancer enhancer=new Enhancer();
        //设置模板
        enhancer.setSuperclass(service.getClass());
        //回调函数
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("前置增强内容---------------");
                methodProxy.invoke(service,objects);
                return null;
            }
        });
        //创建代理对象
        SomeServiceImpl proxy = (SomeServiceImpl)enhancer.create();
        //代理对象调用原方法
        proxy.doSome();

    }
}
