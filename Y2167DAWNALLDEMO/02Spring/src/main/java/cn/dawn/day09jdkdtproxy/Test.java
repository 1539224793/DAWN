package cn.dawn.day09jdkdtproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Dawn on 2018/3/8.
 */
public class Test {
    public static void main(String[] args) {
        /*匿名内部类要想得到外面的值，需要把外面的值改为常量*/
        final ISomeService service=new SomeServiceImpl();
        /*用动态代理的方式生成ISomeService的对象，就是增强后的对象，可以看看newProxyInstance的方法参数，就有方法去写了*/
        /*InvocationHandler是由代理实例的调用处理程序实现的接口。*/
        ISomeService proxy=(ISomeService)Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), new InvocationHandler() {
            /**
             *invoke：每个代理实例都有一个关联的调用处理程序。当在代理实例上调用方法时，方法调用将被编码并分派给invoke 其调用处理程序的方法。
             * @param proxy     代理对象，没啥用
             * @param method        反射获取的方法
             * @param args          方法的参数
             * @return
             * @throws Throwable
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("before===================");
                method.invoke(service,args);//相当于执行目标类型的方法
                return null;
            }
        });
        proxy.doSome();
    }
}
