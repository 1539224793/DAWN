package cn.dawn.day04aop.dao.impl;

import cn.dawn.day04aop.dao.IHellowDAO;

/**
 * Created by Dawn on 2018/3/5.
 */
/*dao层实现类*/
public class HellowDAOImpl implements IHellowDAO{

    public void doSome() {
        System.out.println("数据已经成功写入到DB");
    }
}
