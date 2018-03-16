package cn.my.Dome02.service;

import cn.my.Dome02.dao.BookDao;
import cn.my.Dome02.entity.Book;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * Created by 浅笑 on 2018/3/13.
 */
public class BookServiceImpl extends JdbcDaoSupport implements BookService{
    BookDao dao;

    public BookDao getDao() {
        return dao;
    }

    public void setDao(BookDao dao) {
        this.dao = dao;
    }

    public List<Book> find() {
        return dao.find();
    }

}
