package cn.dawn.day07annotationdi;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Dawn on 2018/3/3.
 */
public class test20180306 {


    @Test
    /*di注解注入*/
    public void t01(){
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext-day07annotationdi.xml");
        Student student = (Student) context.getBean("student");
        System.out.println("学生"+student.getName()+"开"+student.getCar().getType());
    }
}
