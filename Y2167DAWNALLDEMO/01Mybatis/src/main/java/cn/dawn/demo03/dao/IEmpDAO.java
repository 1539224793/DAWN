package cn.dawn.demo03.dao;

import cn.dawn.demo03.entity.Emp;

/**
 * Created by Dawn on 2018/2/26.
 */
public interface IEmpDAO {
    /*多对一单挑sql*/
    public Emp findempnoALLDept(Integer empNo);
    /*多对一多条sql*/
    public Emp findempnoALLDeptMoreSQL(Integer empNo);
}
