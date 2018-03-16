package cn.dawn.demo03.dao;


import cn.dawn.demo03.entity.Book;

import java.util.List;
import java.util.Map;

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

    //根据多条件查询map版
    public List<Book> findtrueBookMap(Map<String, Object> map);
    //根据多条件查询index版
    public List<Book> findtrueBookIndex(String bookName, Integer bookPrice);
    //智能标签where if
    public List<Book> findtrueBookByIf(String bookName, Integer bookPrice);
    //智能标签where choose
    public List<Book> findtrueBookByChoose(Integer bookPrice);
    //智能标签where foreach array
    public List<Book> findtrueBookByForeachArray(int[] array);
    //智能标签where foreach list
    public List<Book> findtrueBookByForeachList(List<Integer> list);
    //智能标签where foreach list
    public List<Book> findtrueBookByForeachListBook(List<Book> list);
}
