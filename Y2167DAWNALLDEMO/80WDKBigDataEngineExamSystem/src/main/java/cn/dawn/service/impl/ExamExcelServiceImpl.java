package cn.dawn.service.impl;

import cn.dawn.dao.ExamExcelDao;
import cn.dawn.dao.impl.ExamExcelDaoImpl;
import cn.dawn.entity.StuAnswerInfo;
import cn.dawn.service.ExamExcelService;

/**
 * Created by Dawn on 2018/1/31.
 */
public class ExamExcelServiceImpl implements ExamExcelService{
    ExamExcelDao ed=new ExamExcelDaoImpl();

    public void insertStuAnswer(StuAnswerInfo stuAnswerInfo) {
        ed.insertStuAnswer(stuAnswerInfo);
    }
}
