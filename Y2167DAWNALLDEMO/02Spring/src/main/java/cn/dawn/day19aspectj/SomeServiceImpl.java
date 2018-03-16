package cn.dawn.day19aspectj;



/**
 * Created by Dawn on 2018/3/8.
 */
public class SomeServiceImpl implements ISomeService {

    public void insert() {
        System.out.println("insert ok");
    }

    public void delete() {
        System.out.println("delete ok");

    }

    public void select() {
        System.out.println("select ok");

    }

    public void update() {
        System.out.println("update ok");
        int a=5/0;
        System.out.println(a);

    }
}
