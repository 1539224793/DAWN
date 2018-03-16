package cn.dawn.demo03.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dawn on 2018/2/26.
 */
public class Dept {
    private Integer deptNo;
    private String deptName;
    private List<Emp> emps=new ArrayList<Emp>();

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }
}
