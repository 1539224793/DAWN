package cn.dawn.day14aop04;

import org.springframework.aop.ThrowsAdvice;

/**
 * Created by Dawn on 2018/3/8.
 */
public class MyThrowsAdvice implements ThrowsAdvice {
    public void afterThrowing(Exception ex){
        System.out.println("网络中断XXXXX-错误号05289");
    }
}
