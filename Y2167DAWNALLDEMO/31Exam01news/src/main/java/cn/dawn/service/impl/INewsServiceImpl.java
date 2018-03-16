package cn.dawn.service.impl;

import cn.dawn.dao.INewsDAO;
import cn.dawn.entity.News;
import cn.dawn.entity.Talk;
import cn.dawn.service.INewsService;
import cn.dawn.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by Dawn on 2018/3/1.
 */
public class INewsServiceImpl implements INewsService{

    public List<News> findListNews(int pageIndex, int pageSize) {
        SqlSession session= MyBatisUtils.getSession();

        INewsDAO mapper = session.getMapper(INewsDAO.class);
        List<News> lists = mapper.findListNews((pageIndex - 1) * pageSize, pageSize);
        session.close();
        return lists;


    }

    public int getCount() {
        SqlSession session= MyBatisUtils.getSession();

        INewsDAO mapper = session.getMapper(INewsDAO.class);
        int NewsCount = mapper.getCount();
        session.close();
        return NewsCount;
    }

    public int updateNewsContent(int newsid) {
        SqlSession session= MyBatisUtils.getSession();

        INewsDAO mapper = session.getMapper(INewsDAO.class);
        int i = mapper.updateNewsContent(newsid);
        session.commit();
        session.close();
        return i;
    }

    public News findNewsByNewsid(int newsid) {
        SqlSession session= MyBatisUtils.getSession();

        INewsDAO mapper = session.getMapper(INewsDAO.class);
        News news = mapper.findNewsByNewsid(newsid);
        session.close();
        return news;
    }

    public int insertTalks(Talk talk) {
        SqlSession session= MyBatisUtils.getSession();

        INewsDAO mapper = session.getMapper(INewsDAO.class);
        int i = mapper.insertTalks(talk);
        session.commit();
        session.close();
        return i;
    }
}
