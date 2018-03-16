package cn.dawn.demo05pagehelper.dao;


import cn.dawn.demo05pagehelper.entity.Book;

import java.util.List;

/**
 * Created by Dawn on 2018/1/29.
 */
public interface IBookDAO {

    //查全部
    public List<Book> findAllBook();
}
