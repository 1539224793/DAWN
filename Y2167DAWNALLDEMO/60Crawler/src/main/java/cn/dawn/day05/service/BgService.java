package cn.dawn.day05.service;

import cn.dawn.day05.entity.Cnblog;

import java.util.List;

/**
 * Created by Dawn on 2018/3/9.
 */
public interface BgService {
    public List<Cnblog> findAll();

    public List<Cnblog> findPagesCnblog(Integer pageIndex);

    public void insertPagesCnblog(List<Cnblog> lists);
}
