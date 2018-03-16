package cn.dawn.dao;

import cn.dawn.entity.TrueAnswerInfo;

/**
 * Created by Dawn on 2018/2/1.
 */
public interface TrueAnswerDao {
    public int deleteTrueAnswer(String classId);
    public int insertTrueAnswer(TrueAnswerInfo trueanswerinfo);
}
