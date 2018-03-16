package cn.dawn.service.impl;

import cn.dawn.dao.IUserDAO;
import cn.dawn.entity.PagerInfo;
import cn.dawn.entity.User;
import cn.dawn.service.IUserService;
import cn.dawn.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Dawn on 2018/2/25.
 */
public class UserServiceImpl implements IUserService{

    //登陆
    public User loginUser(String userCode, String userPassword) {
        SqlSession session= MyBatisUtils.getSession();

        IUserDAO mapper = session.getMapper(IUserDAO.class);
        User user = mapper.loginUser(userCode, userPassword);
        //System.out.println(user.getUserName());



        session.close();
        return user;
    }

    //改密码
    public int updateUserPassword(String userCode, String userPassword) {
        SqlSession session= MyBatisUtils.getSession();

        IUserDAO mapper = session.getMapper(IUserDAO.class);

        int i = mapper.updateUserPassword(userCode, userPassword);
        //System.out.println(user.getUserName());

        session.commit();

        session.close();
        return i;
    }

    //用户分页
    public PagerInfo<User> findPagerUser(int pageIndex, int pageSize) {
        SqlSession session= MyBatisUtils.getSession();

        IUserDAO mapper = session.getMapper(IUserDAO.class);

        List<User> lists=mapper.findListUser((pageIndex-1)*pageSize,pageSize);
        /*for (User item:lists) {
            item.setAge(new Date().getYear()-item.getBirthday().getYear());
        }*/
        Integer gcount = mapper.getCount();
        session.close();
        PagerInfo<User> page=new PagerInfo<User>();

        page.setLists(lists);
        page.setTotalSize(gcount);
        page.setPageSize(pageSize);
        page.setPageIndex(pageIndex);
        page.setUrl("/smbms/UserServlet?oper=pageUser");



        return page;
    }
}
