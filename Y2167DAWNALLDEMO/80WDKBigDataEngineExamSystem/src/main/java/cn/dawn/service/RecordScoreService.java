package cn.dawn.service;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created by Dawn on 2018/2/2.
 */
public interface RecordScoreService {
    public String allMethodCalls(String classId,String path);

    public HashMap<String,Integer> rScoreMethod(String classId) throws SQLException;

    public String write(HashMap<String,Integer> rscores,String classId,String path);

    public HashMap<Integer,Integer> errorCount(String classId) throws SQLException;
}
