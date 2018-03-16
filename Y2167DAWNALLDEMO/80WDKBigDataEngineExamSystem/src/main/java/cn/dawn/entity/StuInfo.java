package cn.dawn.entity;

/**
 * Created by Dawn on 2018/1/30.
 */
public class StuInfo {
    private Integer stuId;
    private String stuName;
    private String stuPassword;
    private String classId;

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    private Integer stuType;
    private Integer stuIsBaned;

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuPassword() {
        return stuPassword;
    }

    public void setStuPassword(String stuPassword) {
        this.stuPassword = stuPassword;
    }

    public Integer getStuType() {
        return stuType;
    }

    public void setStuType(Integer stuType) {
        this.stuType = stuType;
    }

    public Integer getStuIsBaned() {
        return stuIsBaned;
    }

    public void setStuIsBaned(Integer stuIsBaned) {
        this.stuIsBaned = stuIsBaned;
    }
}
