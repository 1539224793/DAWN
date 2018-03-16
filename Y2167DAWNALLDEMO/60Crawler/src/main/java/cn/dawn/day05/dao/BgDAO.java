package cn.dawn.day05.dao;

import cn.dawn.day05.entity.Cnblog;

import java.util.List;

/**
 * Created by Dawn on 2018/3/9.
 */
public interface BgDAO {
    public Integer insertcnblog(Cnblog cnblog);

    public void delectAll();

    public List<Cnblog> findAllCnblog();
}
