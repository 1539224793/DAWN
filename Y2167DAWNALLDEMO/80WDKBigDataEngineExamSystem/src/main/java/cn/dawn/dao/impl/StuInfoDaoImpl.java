package cn.dawn.dao.impl;

import cn.dawn.dao.BaseDao;
import cn.dawn.dao.StuInfoDao;
import cn.dawn.entity.StuInfo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dawn on 2018/1/30.
 */
public class StuInfoDaoImpl extends BaseDao implements StuInfoDao{

    public StuInfo loginFindStuInfo(StuInfo stuinfo) throws SQLException {
        StuInfo logininfo=null;
        String sql="select * from stuinfo where stuname=? and stupassword=?";
        Object [] parse={stuinfo.getStuName(),stuinfo.getStuPassword()};
        ResultSet rs = this.exeQuery(sql, parse);
        if(rs.next()){
            logininfo=new StuInfo();
            logininfo.setStuId(rs.getInt("stuId"));
            logininfo.setStuName(rs.getString("stuName"));
            logininfo.setStuPassword(rs.getString("stuPassword"));
            logininfo.setStuType(rs.getInt("stuType"));
            logininfo.setStuIsBaned(rs.getInt("stuIsBaned"));
            logininfo.setClassId(rs.getString("classId"));
        }
        this.allClose();
        return logininfo;
    }
}
