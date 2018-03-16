package cn.dawn.service;

import cn.dawn.entity.PagerInfo;
import cn.dawn.entity.User;


/**
 * Created by Dawn on 2018/2/25.
 */
public interface IUserService {
    /*登陆*/
    public User loginUser(String userCode, String userPassword);
    /*修改密码*/
    public int updateUserPassword(String userCode,String userPassword);
    /*用户列表分页*/
    public PagerInfo<User> findPagerUser(int pageIndex, int pageSize);
}
