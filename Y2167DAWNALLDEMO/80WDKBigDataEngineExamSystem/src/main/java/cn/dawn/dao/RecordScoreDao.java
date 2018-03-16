package cn.dawn.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Dawn on 2018/2/2.
 */
public interface RecordScoreDao {
    /**
     * 查找传进来这个参数的班级的全部人员
     * @param classId
     * @return
     */
    public List<String> findExamNames(String classId) throws SQLException;

    /**
     * 根据传的参数查找老师的正确答案
     * @param classId
     * @return
     * @throws SQLException
     */
    public HashMap<Integer,String> findTrueAnswers(String classId) throws SQLException;

    /**
     * 根据学生名字查他的正确答案
     * @param stuname
     * @return
     * @throws SQLException
     */
    public HashMap<Integer,String> findStuAnswers(String stuname) throws SQLException;
}
