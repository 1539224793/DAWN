package cn.dawn.day06autowire;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Dawn on 2018/3/3.
 */
public class test20180306 {


    @Test
    /*di自动注入*/
    public void t01(){
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext-day06autowire.xml");
        Student student = (Student) context.getBean("student");
        System.out.println("学生"+student.getName()+"开着"+student.getCar().getColor()+"的"+student.getCar().getType());
    }
}
