package cn.dawn.day21jdbctemplate.dao;

import cn.dawn.day21jdbctemplate.entity.Book;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Dawn on 2018/3/13.
 */
public class BookDAOImpl extends JdbcDaoSupport implements IBookDAO {
    public List<Book> findAllBooks() {
        String sql="select * from book";
        List<Book> lists = this.getJdbcTemplate().query(sql, new RowMapper<Book>() {
            public Book mapRow(ResultSet rs, int i) throws SQLException {
                Book book=new Book();
                book.setBookAuthor(rs.getString("bookAuthor"));
                book.setBookID(rs.getInt("bookId"));
                book.setBookName(rs.getString("bookName"));
                book.setBookPrice(rs.getInt("bookPrice"));
                return book;
            }
        });
        return lists;
    }
}
