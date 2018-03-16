package cn.dawn.demo03.dao;

import cn.dawn.demo03.entity.Dept;

/**
 * Created by Dawn on 2018/2/26.
 */
public interface IDeptDAO {
    /*一对多单挑sql*/
    public Dept findDeptnoALLEmps(Integer deptNo);
    /*一对多多条sql*/
    public Dept findDeptnoALLEmpsMoreSql(Integer deptNo);
}
