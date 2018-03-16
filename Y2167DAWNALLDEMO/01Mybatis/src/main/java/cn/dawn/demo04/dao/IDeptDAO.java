package cn.dawn.demo04.dao;

import cn.dawn.demo04.entity.Dept;

/**
 * Created by Dawn on 2018/2/26.
 */
public interface IDeptDAO {

    /*一对多多条sql*//*延迟加载*/
    public Dept findDeptnoALLEmpsMoreSql(Integer deptNo);

    /*增删改对一级缓存的影响*/
    public int addDept(Dept dept);
}
