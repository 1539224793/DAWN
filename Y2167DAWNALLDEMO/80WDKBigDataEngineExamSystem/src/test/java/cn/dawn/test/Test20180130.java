package cn.dawn.test;

import cn.dawn.dao.StuInfoDao;
import cn.dawn.dao.impl.StuInfoDaoImpl;
import cn.dawn.entity.StuInfo;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Created by Dawn on 2018/1/30.
 */
public class Test20180130 {
    @Test
    public void t1Login() throws SQLException {
        StuInfoDao sd=new StuInfoDaoImpl();
        StuInfo stuinfo=new StuInfo();
        stuinfo.setStuName("1");
        stuinfo.setStuPassword("1");

        StuInfo logininfo = sd.loginFindStuInfo(stuinfo);
        if(logininfo!=null){
            System.out.println("登陆名为"+logininfo.getStuName());
        }
    }
}
