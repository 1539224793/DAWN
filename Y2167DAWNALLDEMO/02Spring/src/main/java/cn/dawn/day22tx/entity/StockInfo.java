package cn.dawn.day22tx.entity;

/**
 * Created by Dawn on 2018/3/15.
 */
public class StockInfo {
    private Integer sid;
    private String sname;
    private Integer scount;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getScount() {
        return scount;
    }

    public void setScount(Integer scount) {
        this.scount = scount;
    }
}
