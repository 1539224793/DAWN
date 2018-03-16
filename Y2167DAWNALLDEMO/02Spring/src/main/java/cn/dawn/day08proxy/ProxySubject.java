package cn.dawn.day08proxy;

/**
 * Created by Dawn on 2018/3/6.
 */
public class ProxySubject implements Subject {
    Subject subject;
    public void request() {
        System.out.println("before");
        subject.request();
        System.out.println("after");

    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
