package cn.dawn.day05.service.impl;

import cn.dawn.day05.dao.BgDAO;
import cn.dawn.day05.entity.Cnblog;
import cn.dawn.day05.service.BgService;
import cn.dawn.day05.utils.CnblogsModel;
import cn.dawn.day05.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dawn on 2018/3/9.
 */
public class BgServiceImpl implements BgService {


    public List<Cnblog> findAll() {
        SqlSession session= MyBatisUtils.getSession();
        BgDAO mapper = session.getMapper(BgDAO.class);
        List<Cnblog> allCnblog = mapper.findAllCnblog();
        session.close();
        return allCnblog;
    }

    public List<Cnblog> findPagesCnblog(Integer pageIndex) {
        ArrayList<Cnblog> cnblogs = CnblogsModel.GetContens(CnblogsModel.SendPostCnBlog("http://www.cnblogs.com/mvc/AggSite/PostList.aspx", CnblogsModel.jsonMaker(pageIndex)));
        return cnblogs;
    }

    public void insertPagesCnblog(List<Cnblog> lists) {
        SqlSession session= MyBatisUtils.getSession();

        BgDAO mapper = session.getMapper(BgDAO.class);
        for (Cnblog cnblog :lists) {
            System.out.println(cnblog);
            mapper.insertcnblog(cnblog);

        }
        session.commit();
        session.close();

    }
}
