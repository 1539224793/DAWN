package cn.dawn.day21JdbcTemplate;


import cn.dawn.day21jdbctemplate.entity.Book;
import cn.dawn.day21jdbctemplate.service.IBookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Dawn on 2018/3/3.
 */
public class test20180313 {
    @Test
    /*aop代理工厂bean异常增强*/
    public void t01(){
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext-day21JdbcTemplate.xml");
        IBookService service = (IBookService) context.getBean("bookService");
        List<Book> allBooks = service.findAllBooks();
        for (Book item:allBooks) {
            System.out.println(item);
        }

    }
}
