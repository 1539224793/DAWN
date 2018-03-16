package cn.dawn.dao.impl;

import cn.dawn.dao.BaseDao;
import cn.dawn.dao.ExamExcelDao;
import cn.dawn.entity.StuAnswerInfo;

/**
 * Created by Dawn on 2018/1/31.
 */
public class ExamExcelDaoImpl extends BaseDao implements ExamExcelDao{
    public void insertStuAnswer(StuAnswerInfo stuAnswerInfo) {
        String sql="insert into stuanswer(stuName,tId,tAnswer,createTime,classId) values (?,?,?,?,?)";
        Object[] obj={stuAnswerInfo.getStuName(),stuAnswerInfo.gettID(),stuAnswerInfo.gettAnswer(),stuAnswerInfo.getCreateTime(),stuAnswerInfo.getClassId()};
        this.exeUpDate(sql,obj);
    }
}
