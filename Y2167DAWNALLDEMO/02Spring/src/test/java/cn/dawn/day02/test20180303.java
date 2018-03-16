package cn.dawn.day02;

import cn.dawn.day02di.Stu;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Dawn on 2018/3/3.
 */
public class test20180303 {
    @Test
    /*域属性*/
    public void t01(){
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext-day02.xml");
        Stu stu = (Stu) context.getBean("stu");
        System.out.println(stu.getName()+"开"+stu.getCar().getType());
    }
}
