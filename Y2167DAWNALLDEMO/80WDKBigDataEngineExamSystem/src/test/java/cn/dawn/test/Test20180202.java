package cn.dawn.test;

import cn.dawn.service.RecordScoreService;
import cn.dawn.service.impl.RecordScoreServiceImpl;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Dawn on 2018/2/2.
 */
public class Test20180202 {
    @Test
    public void t3Shi() throws SQLException {
        Date date=new Date();
        System.out.println(+date.getMonth()+1+"月"+date.getDate()+"日"+date.getHours()+"时"+date.getMinutes()+"分");
    }

    @Test
    public void t2Rscore() throws SQLException {
        RecordScoreService rs=new RecordScoreServiceImpl();
        HashMap<String, Integer> stuScoreMap = rs.rScoreMethod("2228");
        rs.write(stuScoreMap,"2228","D:/");
    }


    @Test
    public void t1Rscore() throws SQLException {
        RecordScoreService rs=new RecordScoreServiceImpl();
        HashMap<String, Integer> stuScoreMap = rs.rScoreMethod("2228");

        for (Map.Entry<String, Integer> entry : stuScoreMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }

        /*for(Iterator iter = stuScoreMap.entrySet().iterator(); iter.hasNext();){
            Map.Entry element = (Map.Entry)iter.next();
            Object strKey = element.getKey();
            Object strObj = element.getValue();

            System.out.println("myMap.get(\""+strKey+"\")="+strObj);
        }*/
    }
}
