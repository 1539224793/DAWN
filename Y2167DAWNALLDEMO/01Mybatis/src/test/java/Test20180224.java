
import cn.dawn.demo02gao.dao.IBookDAO;
import cn.dawn.demo02gao.entity.Book;
import cn.dawn.util.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dawn on 2018/1/29.
 */
public class Test20180224 {


    ///智能标签where + foreach list Book自定义list 进行多条件查询
    @Test
    public void t9selectZhiNengByForeachListBook(){
        SqlSession session= MyBatisUtils.getSession();

        IBookDAO mapper = session.getMapper(IBookDAO.class);
        List<Book> list=new ArrayList<Book>();
        Book b1=new Book();
        b1.setBookID(1);
        Book b2=new Book();
        b2.setBookID(2);
        list.add(b1);
        list.add(b2);
        List<Book> books = mapper.findtrueBookByForeachListBook(list);
        for (Book items:books) {
            System.out.println(items.getBookName());
        }

        session.close();

    }


    ///智能标签where + foreach list 进行多条件查询
    @Test
    public void t8selectZhiNengByForeachList(){
        SqlSession session= MyBatisUtils.getSession();

        IBookDAO mapper = session.getMapper(IBookDAO.class);
        List<Integer> list=new ArrayList<Integer>();
        list.add(1);
        list.add(3);
        List<Book> books = mapper.findtrueBookByForeachList(list);
        for (Book items:books) {
            System.out.println(items.getBookName());
        }

        session.close();

    }


    ///智能标签where + foreach array 进行多条件查询
    @Test
    public void t7selectZhiNengByForeachArray(){
        SqlSession session= MyBatisUtils.getSession();

        IBookDAO mapper = session.getMapper(IBookDAO.class);
        int[] array={1,3};
        List<Book> books = mapper.findtrueBookByForeachArray(array);
        for (Book items:books) {
            System.out.println(items.getBookName());
        }

        session.close();

    }



    ///智能标签where + choose进行多条件查询
    @Test
    public void t6selectZhiNengByChoose(){
        SqlSession session= MyBatisUtils.getSession();

        IBookDAO mapper = session.getMapper(IBookDAO.class);
        List<Book> books = mapper.findtrueBookByChoose(500);
        for (Book items:books) {
            System.out.println(items.getBookName());
        }

        session.close();

    }


    ///智能标签where + if 进行多条件查询
    @Test
    public void t5selectZhiNengByIf(){
        SqlSession session= MyBatisUtils.getSession();

        IBookDAO mapper = session.getMapper(IBookDAO.class);
        List<Book> books = mapper.findtrueBookByIf("心",40);
        for (Book items:books) {
            System.out.println(items.getBookName());
        }

        session.close();

    }


    ///多条件查询Index版
    @Test
    public void t4selectmoreIndex(){
        SqlSession session= MyBatisUtils.getSession();

        IBookDAO mapper = session.getMapper(IBookDAO.class);
        List<Book> books = mapper.findtrueBookIndex("心",40);
        for (Book items:books) {
            System.out.println(items.getBookName());
        }

        session.close();

    }

    ///多条件查询map版
    @Test
    public void t3selectmoreMap(){
        SqlSession session= MyBatisUtils.getSession();

        IBookDAO mapper = session.getMapper(IBookDAO.class);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("bookName","心");
        map.put("bookPrice",40);
        List<Book> books = mapper.findtrueBookMap(map);
        for (Book items:books) {
            System.out.println(items.getBookName());
        }

        session.close();

    }


    ///添加后返回主键列的测试方法
    //加使用mybatis工具类
    @Test
    public void t2Insert(){
        SqlSession session= MyBatisUtils.getSession();
        Book book=new Book();
        book.setBookName("心想事成");
        book.setBookAuthor("孟七");
        book.setBookPrice(999);
        IBookDAO mapper = session.getMapper(IBookDAO.class);
        int i = mapper.insertBook(book);
        session.commit();
        System.out.println("受影响的行数"+i);
        System.out.println("返回的主键列的id=============="+book.getBookID());

        session.close();

    }


    ///查全部用resultmap
    @Test
    public void t1SelectAll(){
        String path = "mybatis-config.xml";

        try {
            InputStream e = Resources.getResourceAsStream(path);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(e);
            SqlSession session = factory.openSession();
            IBookDAO mapper = session.getMapper(IBookDAO.class);
            List<Book> list = mapper.findAllBook();
            for (Book item:list) {
                System.out.println(item.getBookName());
            }

            session.close();
        } catch (IOException var9) {
            var9.printStackTrace();
        }
    }
}
