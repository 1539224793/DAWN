package cn.dawn.day17auto01;


import cn.dawn.day17atuo01.ISomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Dawn on 2018/3/3.
 */
public class test20180312 {
    @Test
    /*默认自动代理*/
    public void t01(){
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext-day17auto01.xml");
        ISomeService service = (ISomeService) context.getBean("service");

        service.select();

    }
}
