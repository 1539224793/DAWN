package cn.dawn.day05.entity;

/**
 * Created by Dawn on 2018/3/9.
 */
public class Cnblog {
    public Integer bgid;
    public String bgtitle;
    public String bgpath;

    @Override
    public String toString() {
        return "Cnblog{" +
                "bgid=" + bgid +
                ", bgtitle='" + bgtitle + '\'' +
                ", bgpath='" + bgpath + '\'' +
                '}';
    }

    public String getBgtitle() {
        return bgtitle;
    }

    public void setBgtitle(String bgtitle) {
        this.bgtitle = bgtitle;
    }

    public String getBgpath() {
        return bgpath;
    }

    public void setBgpath(String bgpath) {
        this.bgpath = bgpath;
    }

    public Integer getBgid() {
        return bgid;
    }

    public void setBgid(Integer bgid) {
        this.bgid = bgid;
    }
}
