package cn.dawn.dao;


import cn.dawn.entity.User;

import java.util.List;

/**
 * Created by Dawn on 2018/2/25.
 */
public interface IUserDAO {
    //登陆
    public User loginUser(String userCode,String userPassword);
    //改密码
    public int updateUserPassword(String userCode,String userPassword);
    /*用户分页*/
    public List<User> findListUser(int pageIndex, int pageSize);
    public int getCount();
}
