package cn.dawn.service.impl;

import cn.dawn.dao.StuInfoDao;
import cn.dawn.dao.impl.StuInfoDaoImpl;
import cn.dawn.entity.StuInfo;
import cn.dawn.service.StuInfoService;

import java.sql.SQLException;

/**
 * Created by Dawn on 2018/1/30.
 */
public class StuInfoServiceImpl implements StuInfoService {
    StuInfoDao sd=new StuInfoDaoImpl();
    public StuInfo loginFindStuInfo(StuInfo stuinfo) throws SQLException {
        return sd.loginFindStuInfo(stuinfo);
    }
}
