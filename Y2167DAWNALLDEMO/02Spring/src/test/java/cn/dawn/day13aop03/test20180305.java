package cn.dawn.day13aop03;

import cn.dawn.day13aop03.SomeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Dawn on 2018/3/3.
 */
public class test20180305 {
    @Test
    /*aop代理工厂bean环绕增强*/
    public void t01(){
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext-day13aop03.xml");
        SomeServiceImpl service = (SomeServiceImpl) context.getBean("proxyfactory");
        service.doSome();
    }
}
