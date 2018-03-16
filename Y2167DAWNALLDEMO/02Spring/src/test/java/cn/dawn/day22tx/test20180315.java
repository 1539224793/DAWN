package cn.dawn.day22tx;


import cn.dawn.day22tx.entity.StockException;
import cn.dawn.day22tx.service.IStockPayService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Dawn on 2018/3/3.
 */
public class test20180315 {
    @Test
    /*aspectj xml方式*/
    public void t03() {
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext-day22tx.xml");
        IStockPayService service = (IStockPayService) context.getBean("stockpPayService");
        boolean flag = false;
        try {
            flag = service.buyStock(1, 100, 1, 20);
        } catch (StockException e) {
            e.printStackTrace();
        }
        if(flag){
            System.out.println("购买成功");
        }

    }


    @Test
    /*注解方式*/
    public void t02() {
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext-day22tx.xml");
        IStockPayService service = (IStockPayService) context.getBean("stockpPayService");
        boolean flag = false;
        try {
            flag = service.buyStock(1, 100, 1, 20);
        } catch (StockException e) {
            e.printStackTrace();
        }
        if(flag){
            System.out.println("购买成功");
        }

    }

    @Test
    /*代理工厂bean的方式*/
    public void t01() {
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext-day22tx.xml");
        IStockPayService service = (IStockPayService) context.getBean("txService");
        boolean flag = false;
        try {
            flag = service.buyStock(1, 100, 1, 20);
        } catch (StockException e) {
            e.printStackTrace();
        }
        if(flag){
            System.out.println("购买成功");
        }

    }
}
