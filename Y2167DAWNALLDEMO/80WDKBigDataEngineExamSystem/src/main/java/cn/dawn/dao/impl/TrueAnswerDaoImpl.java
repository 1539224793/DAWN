package cn.dawn.dao.impl;

import cn.dawn.dao.BaseDao;
import cn.dawn.dao.TrueAnswerDao;
import cn.dawn.entity.TrueAnswerInfo;

/**
 * Created by Dawn on 2018/2/1.
 */
public class TrueAnswerDaoImpl extends BaseDao implements TrueAnswerDao {
    public int deleteTrueAnswer(String classId) {
        String sql="delete from trueanswer where classid=?";
        int rs = this.exeUpDate(sql, classId);

        return rs;
    }

    public int insertTrueAnswer(TrueAnswerInfo trueanswerinfo) {
        String sql="insert into trueanswer(classId,tId,tAnswer) values(?,?,?)";
        Object [] obj={trueanswerinfo.getClassId(),trueanswerinfo.gettID(),trueanswerinfo.gettAnswer()};
        int rs = this.exeUpDate(sql, obj);
        return rs;
    }
}
