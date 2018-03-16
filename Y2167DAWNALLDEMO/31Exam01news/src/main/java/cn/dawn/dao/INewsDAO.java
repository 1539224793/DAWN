package cn.dawn.dao;

import cn.dawn.entity.News;
import cn.dawn.entity.Talk;

import java.util.List;

/**
 * Created by Dawn on 2018/3/1.
 */
public interface INewsDAO {
    /*分页*/
    public List<News> findListNews(int pageIndex, int pageSize);
    public int getCount();
    /*分页完毕*/

    /*给访问量加一*/
    public int updateNewsContent(int newsid);
    /*查看全部评论和内容*/
    public News findNewsByNewsid(int newsid);
    /*新增评论*/
    public int insertTalks(Talk talk);
}
