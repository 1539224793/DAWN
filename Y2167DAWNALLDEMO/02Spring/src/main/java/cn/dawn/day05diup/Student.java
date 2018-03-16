package cn.dawn.day05diup;

/**
 * Created by Dawn on 2018/3/5.
 */
//student类
public class Student {
    private String name;
    private Integer age;
    private Car car;

    //带参构造
    public Student(String name, Integer age, Car car) {
        this.name = name;
        this.age = age;
        this.car = car;
    }

    //无参构造
    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
