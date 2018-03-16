package cn.dawn.day20aspectjxml;


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
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext-day20aspectjxml.xml");
        ISomeService service = (ISomeService) context.getBean("service");
        IBookService bookservice = (IBookService) context.getBean("bookservice");

        try {
            bookservice.selectAllBooks();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("================观察==================");
        service.update();
        System.out.println("================观察==================");
        service.delete();
        System.out.println("================观察==================");
        service.select();
        System.out.println("================观察==================");
    }
}
