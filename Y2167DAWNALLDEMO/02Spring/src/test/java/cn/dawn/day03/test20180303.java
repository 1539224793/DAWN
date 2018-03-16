package cn.dawn.day03;

import cn.dawn.day02di.Stu;
import cn.dawn.day03printer.printer.Printer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Dawn on 2018/3/3.
 */
public class test20180303 {
    @Test
    /*打印机案例*/
    public void t01(){
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext-day03.xml");
        Printer printer = (Printer) context.getBean("printer");
        printer.print();
    }
}
