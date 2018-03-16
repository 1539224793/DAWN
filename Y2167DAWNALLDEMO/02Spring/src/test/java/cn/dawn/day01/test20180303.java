package cn.dawn.day01;

import cn.dawn.day01.service.DawnService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Dawn on 2018/3/3.
 */
public class test20180303 {
    @Test
    /*入门案例*/
    public void t01(){

        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext01.xml");
        DawnService service = (DawnService) context.getBean("service");
        System.out.println(service);
    }
}
