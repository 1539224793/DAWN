package cn.dawn.day08proxy;


/**
 * Created by Dawn on 2018/3/6.
 */
public class RealSubject implements Subject {
    public void request() {
        System.out.println("request本身——————————————————————————————-");
    }
}
