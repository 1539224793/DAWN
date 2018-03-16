package cn.dawn.service;

import cn.dawn.entity.StuInfo;

import java.sql.SQLException;

/**
 * Created by Dawn on 2018/1/30.
 */
public interface StuInfoService{
        public StuInfo loginFindStuInfo(StuInfo stuinfo) throws SQLException;
}
