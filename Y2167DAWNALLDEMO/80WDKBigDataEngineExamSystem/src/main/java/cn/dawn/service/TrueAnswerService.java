package cn.dawn.service;

import cn.dawn.entity.TrueAnswerInfo;

/**
 * Created by Dawn on 2018/2/1.
 */
public interface TrueAnswerService {
    public int deleteTrueAnswer(String classId);
    public int insertTrueAnswer(TrueAnswerInfo trueanswerinfo);
}
