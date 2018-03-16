package cn.dawn.dao.impl;

import cn.dawn.dao.BaseDao;
import cn.dawn.dao.RecordScoreDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Dawn on 2018/2/2.
 */
public class RecordScoreDaoImpl extends BaseDao implements RecordScoreDao {
    public List<String> findExamNames(String classId) throws SQLException {
        List<String> stunames=null;
        String sql="select * from stuinfo where classid=?";
        ResultSet rs = this.exeQuery(sql, classId);
        if(rs!=null){
            stunames=new ArrayList<String>();
            while (rs.next()){
                String name=rs.getString("stuname");
                stunames.add(name);
            }
        }
        this.allClose();
        return stunames;
    }

    public HashMap<Integer, String> findTrueAnswers(String classId) throws SQLException {
        HashMap<Integer, String> trueAnswers=null;
        String sql="select * from trueanswer where classId=?";
        ResultSet rs = this.exeQuery(sql, classId);
        if(rs!=null){
            trueAnswers=new HashMap<Integer, String>();
            while (rs.next()){
                Integer tid=rs.getInt("tid");
                String tanswer=rs.getString("tanswer");
                trueAnswers.put(tid,tanswer);
            }
        }
        this.allClose();
        return trueAnswers;
    }

    public HashMap<Integer, String> findStuAnswers(String stuname) throws SQLException {
        HashMap<Integer, String> stuAnswers=null;
        String sql="select * from stuanswer where stuname=?";
        ResultSet rs = this.exeQuery(sql, stuname);
        if(rs!=null){
            stuAnswers=new HashMap<Integer, String>();
            while (rs.next()){
                Integer tid=rs.getInt("tid");
                String tanswer=rs.getString("tanswer");
                stuAnswers.put(tid,tanswer);
            }
        }
        this.allClose();
        return stuAnswers;
    }
}
