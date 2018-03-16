package cn.dawn.day05.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Dawn on 2018/2/24.
 */
public class MyBatisUtils {

    static String path = "mybatis-config.xml";
    static InputStream e;
    static SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    static SqlSessionFactory factory;
    static {
        try {
            e = Resources.getResourceAsStream(path);
            factory = builder.build(e);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }


    public static SqlSession getSession(){
        return factory.openSession();
    }
}
