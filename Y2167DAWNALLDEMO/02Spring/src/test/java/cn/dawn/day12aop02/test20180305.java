package cn.dawn.day12aop02;

        import cn.dawn.day12aop02.SomeServiceImpl;
        import org.junit.Test;
        import org.springframework.context.ApplicationContext;
        import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Dawn on 2018/3/3.
 */
public class test20180305 {
    @Test
    /*aop代理工厂bean后置增强*/
    public void t01(){
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext-day12aop02.xml");
        SomeServiceImpl service = (SomeServiceImpl) context.getBean("proxyfactory");
        service.doSome();
    }
}
