import cn.dawn.demo01.entity.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Dawn on 2018/1/29.
 */
public class Test20180129 {

    /*Logger logger=Logger.getLogger("xxx");*/
    ///查单独
    @Test
    public void t5findOne(){
        /*logger.info("这是查单独");*/
        String path = "mybatis-config.xml";

        try {
            InputStream e = Resources.getResourceAsStream(path);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(e);
            SqlSession session = factory.openSession();


            Book book = session.selectOne("findOneBookByPK", 1);
            System.out.println("书名"+book.getBookName());


            session.close();
        } catch (IOException var9) {
            var9.printStackTrace();
        }
    }

    ///删除
    @Test
    public void t4delete(){
        String path = "mybatis-config.xml";

        try {
            InputStream e = Resources.getResourceAsStream(path);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(e);
            SqlSession session = factory.openSession();




            int count123 = session.delete("deleteBook",4);
            session.commit();
            System.out.println(count123);

            session.close();
        } catch (IOException var9) {
            var9.printStackTrace();
        }
    }


    ///修改
    @Test
    public void t3update(){
        String path = "mybatis-config.xml";

        try {
            InputStream e = Resources.getResourceAsStream(path);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(e);
            SqlSession session = factory.openSession();

            Book book=new Book();
            book.setBookID(4);
            book.setBookName("心想事成888");


            int count123 = session.update("updateBook", book);
            session.commit();
            System.out.println(count123);

            session.close();
        } catch (IOException var9) {
            var9.printStackTrace();
        }
    }

    ///添加
    @Test
    public void t2Insert(){
        String path = "mybatis-config.xml";

        try {
            InputStream e = Resources.getResourceAsStream(path);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(e);
            SqlSession session = factory.openSession();

            Book book=new Book();
            book.setBookName("心想事成");
            book.setBookAuthor("孟六");
            book.setBookPrice(999);

            int count123 = session.insert("insertBook", book);
            session.commit();
            System.out.println(count123);

            session.close();
        } catch (IOException var9) {
            var9.printStackTrace();
        }
    }


    ///查全部
    @Test
    public void t1SelectAll(){
        String path = "mybatis-config.xml";

        try {
            InputStream e = Resources.getResourceAsStream(path);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(e);
            SqlSession session = factory.openSession();
            List lists = session.selectList("findAllBook");
            Iterator var7 = lists.iterator();

            while(var7.hasNext()) {
                Book book = (Book)var7.next();
                System.out.println(book.getBookName() + "\t" + book.getBookAuthor());
            }

            session.close();
        } catch (IOException var9) {
            var9.printStackTrace();
        }
    }
}
