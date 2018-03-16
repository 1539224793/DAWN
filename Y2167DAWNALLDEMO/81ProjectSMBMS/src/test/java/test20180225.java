import cn.dawn.dao.IUserDAO;
import cn.dawn.entity.User;
import cn.dawn.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by Dawn on 2018/2/25.
 */
public class test20180225 {

    ///改密码
    @Test
    public void t2updatePassword(){
        SqlSession session= MyBatisUtils.getSession();

        IUserDAO mapper = session.getMapper(IUserDAO.class);
        int i = mapper.updateUserPassword("1", "123");
        session.commit();
        System.out.println(i);



        session.close();

    }

    ///登陆
    @Test
    public void t1login(){
        SqlSession session= MyBatisUtils.getSession();

        IUserDAO mapper = session.getMapper(IUserDAO.class);
        User user = mapper.loginUser("1", "1");
        System.out.println(user.getUserName());


        session.close();

    }
}
