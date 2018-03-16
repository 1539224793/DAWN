package cn.dawn.day21jdbctemplate.service;

import cn.dawn.day21jdbctemplate.entity.Book;

import java.util.List;

/**
 * Created by Dawn on 2018/3/13.
 */
public interface IBookService {
    public List<Book> findAllBooks();
}
