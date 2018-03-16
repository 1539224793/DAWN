package cn.dawn.demo01.dao;

import cn.dawn.demo01.entity.Book;

import java.util.List;

/**
 * Created by Dawn on 2018/1/29.
 */
public interface IBookDAO {
    //查全部
    public List<Book> findAllBook();
    //添加
    public int insertBook(Book book);
    //删除
    public int deleteBook(int id);
    //修改
    public int updateBook(Book book);
    //查都单独
    public Book findOneBookByPK(int id);
    //模糊查询
    public List<Book> likeSelect(String bookName);

}
