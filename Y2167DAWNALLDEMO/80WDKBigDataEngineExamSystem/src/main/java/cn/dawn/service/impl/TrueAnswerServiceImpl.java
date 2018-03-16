package cn.dawn.service.impl;

import cn.dawn.dao.TrueAnswerDao;
import cn.dawn.dao.impl.TrueAnswerDaoImpl;
import cn.dawn.entity.TrueAnswerInfo;
import cn.dawn.service.TrueAnswerService;

/**
 * Created by Dawn on 2018/2/1.
 */
public class TrueAnswerServiceImpl implements TrueAnswerService {
    TrueAnswerDao td=new TrueAnswerDaoImpl();

    public int deleteTrueAnswer(String classId) {
        return td.deleteTrueAnswer(classId);
    }

    public int insertTrueAnswer(TrueAnswerInfo trueanswerinfo) {
        return td.insertTrueAnswer(trueanswerinfo);
    }
}
