package cn.dawn.day04aop;

import cn.dawn.day03printer.printer.Printer;
import cn.dawn.day04aop.service.IHellowService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Dawn on 2018/3/3.
 */
public class test20180305 {
    @Test
    /*aop入门案例*/
    public void t01(){
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext-day04aop.xml");
        IHellowService service = (IHellowService) context.getBean("service");
        service.doSome();
    }
}
