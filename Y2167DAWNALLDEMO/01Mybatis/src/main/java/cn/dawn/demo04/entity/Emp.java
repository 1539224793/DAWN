package cn.dawn.demo04.entity;

import cn.dawn.demo04.entity.Dept;

import java.io.Serializable;

/**
 * Created by Dawn on 2018/2/26.
 */
public class Emp implements Serializable{
    private Integer empNo;
    private String empName;
    private Integer deptNo;
    private Dept dept;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }
}
