package cn.dawn.day18auto02;


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
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext-day18auto02.xml");
        ISomeService service = (ISomeService) context.getBean("service");
        IBookService bookservice = (IBookService) context.getBean("bookservice");

        service.select();
        bookservice.selectAllBooks();

    }
}
