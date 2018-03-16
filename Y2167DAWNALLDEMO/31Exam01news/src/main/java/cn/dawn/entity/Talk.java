package cn.dawn.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Dawn on 2018/3/1.
 */
public class Talk {
    private Integer tid;
    private String content;
    private Date talktime;
    private Integer nid;

    private String ttime;

    public String getTtime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String ttime = formatter.format(talktime);

        return ttime;
    }

    public void setTtime(String ttime) {
        this.ttime = ttime;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTalktime() {
        return talktime;
    }

    public void setTalktime(Date talktime) {
        this.talktime = talktime;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }
}
