package cn.dawn.day08proxy;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Dawn on 2018/3/3.
 */
public class test20180306 {


    @Test
    /*di注解注入*/
    public void t01(){
        Subject realSubject=new RealSubject();

        ProxySubject proxySubject=new ProxySubject();
        proxySubject.setSubject(realSubject);
        proxySubject.request();

        //realSubject.request();
    }
}
