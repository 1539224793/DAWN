package cn.dawn.day04aop.service.impl;

import cn.dawn.day04aop.dao.IHellowDAO;
import cn.dawn.day04aop.service.IHellowService;

/**
 * Created by Dawn on 2018/3/5.
 */
/*service层实现类 */
public class HellowServiceImpl implements IHellowService {
    IHellowDAO dao;
    public void doSome() {
        dao.doSome();
    }

    public IHellowDAO getDao() {
        return dao;
    }

    public void setDao(IHellowDAO dao) {
        this.dao = dao;
    }
}
