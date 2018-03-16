package cn.dawn.demo03.entity;

import java.util.Set;

/**
 * Created by Dawn on 2018/2/26.
 */
public class Category {
    private Integer cid;
    private String cname;
    private Set<Category> cates;

    @Override
    public String toString() {
        return "Category{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", cates=" + cates +
                '}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Set<Category> getCates() {
        return cates;
    }

    public void setCates(Set<Category> cates) {
        this.cates = cates;
    }
}
