package cn.dawn.day19aspectj;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Dawn on 2018/3/3.
 */
public class test20180312 {
    @Test
    /*aop代理工厂bean异常增强*/
    public void t01(){
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext-day19aspectj.xml");
        ISomeService service = (ISomeService) context.getBean("service");

        try {
            service.update();
        }catch (Exception e){
            e.printStackTrace();
        }
        service.delete();
        service.select();
        service.insert();

    }
}
