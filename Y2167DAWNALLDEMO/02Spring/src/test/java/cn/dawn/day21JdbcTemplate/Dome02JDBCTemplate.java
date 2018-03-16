package cn.dawn.day21JdbcTemplate;

import cn.my.Dome02.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 浅笑 on 2018/3/13.
 */
public class Dome02JDBCTemplate {
    @Test
    public void t1(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext02.xml");

        BookService service=(BookService) ac.getBean("bookService");
        service.find();
    }
}
