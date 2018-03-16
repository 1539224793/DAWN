package cn.dawn.day01;

import cn.dawn.day02.ImageCrawler;
import org.junit.Test;

/**
 * Created by Dawn on 2018/3/9.
 */
public class Test20180309 {
    @Test
    /*图片爬虫*/
    public void t2(){


        ImageCrawler.getImage("http://tieba.baidu.com/p/4529628420","D://image");


    }

    @Test
    /*邮箱爬虫*/
    public void t1(){
        try {
            EmailCrawler ec=new EmailCrawler();
            ec.getEmailCrawler("http://tieba.baidu.com/p/4529628420");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
