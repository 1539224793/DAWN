package cn.dawn.day15advisor01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Dawn on 2018/3/3.
 */
public class test20180305 {
    @Test
    /*aop代理工厂bean异常增强*/
    public void t01(){
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext-day15advisor01.xml");
        SomeServiceImpl service = (SomeServiceImpl) context.getBean("proxyfactory");

        service.doSome();
        service.doAny();

    }
}
