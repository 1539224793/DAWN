package cn.dawn.day21jdbctemplate.service;

import cn.dawn.day21jdbctemplate.dao.IBookDAO;
import cn.dawn.day21jdbctemplate.entity.Book;

import java.util.List;

/**
 * Created by Dawn on 2018/3/13.
 */
public class BookServiceImpl implements IBookService{
    private IBookDAO dao;

    public List<Book> findAllBooks() {
        return dao.findAllBooks();
    }

    public IBookDAO getDao() {
        return dao;
    }

    public void setDao(IBookDAO dao) {
        this.dao = dao;
    }
}
