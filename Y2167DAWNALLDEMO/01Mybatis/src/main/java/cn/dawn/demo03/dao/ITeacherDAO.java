package cn.dawn.demo03.dao;

import cn.dawn.demo03.entity.Teacher;

/**
 * Created by Dawn on 2018/2/26.
 */
public interface ITeacherDAO {
    /*多对多*/
    /*根据老师id查询他的全部学生*/
    public Teacher findAllStudentsByTid(Integer tid);
}
