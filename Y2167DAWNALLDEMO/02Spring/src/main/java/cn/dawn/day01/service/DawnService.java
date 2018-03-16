package cn.dawn.day01.service;

/**
 * Created by Dawn on 2018/3/3.
 */
public class DawnService {
    public DawnService(){
        System.out.println("========================DawnService创建=======================");
    }

    private String workInfo;
    private Integer age;
    public void work(){
        System.out.println("info"+workInfo);
    }

    @Override
    public String toString() {
        return "DawnService{" +
                "workInfo='" + workInfo + '\'' +
                ", age=" + age +
                '}';
    }

    public String getWorkInfo() {
        return workInfo;
    }

    public void setWorkInfo(String workInfo) {
        this.workInfo = workInfo;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
