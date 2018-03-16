package cn.dawn.day05diup;

import cn.dawn.day04aop.service.IHellowService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Dawn on 2018/3/3.
 */
public class test20180305 {

    @Test
    /*di集合注入*/
    public void t03(){
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext-day05diup.xml");
        MyCollection mycollection = (MyCollection) context.getBean("mycollection");
        System.out.println(mycollection);
    }



    @Test
    /*diP命名注入*/
    public void t02(){
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext-day05diup.xml");
        Student student = (Student) context.getBean("student");
        System.out.println("学生"+student.getName()+"开着"+student.getCar().getColor()+"的"+student.getCar().getType());
    }



    @Test
    /*di构造注入*/
    public void t01(){
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext-day05diup.xml");
        Student student = (Student) context.getBean("student");
        System.out.println("学生"+student.getName()+"开着"+student.getCar().getColor()+"的"+student.getCar().getType());
    }
}
