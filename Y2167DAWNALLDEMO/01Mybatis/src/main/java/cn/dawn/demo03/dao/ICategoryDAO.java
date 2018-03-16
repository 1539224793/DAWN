package cn.dawn.demo03.dao;

import cn.dawn.demo03.entity.Category;

import java.util.List;

/**
 * Created by Dawn on 2018/2/26.
 */
public interface ICategoryDAO {
    /*自关联*/
    /*根据父id查全部子分类*/
    public List<Category> findAllCategorySetBypid(Integer pid);
}
