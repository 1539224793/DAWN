package cn.dawn.day07annotationdi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Dawn on 2018/3/5.
 */
//student类
    @Component("student")
public class Student {
        @Value("老胡小子，呵呵哒")
    private String name;
        @Value("20")
    private Integer age;

        //@Resource(name = "car")
    @Autowired
    @Qualifier(value = "car")
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
