package cn.dawn.day22tx.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by Dawn on 2018/3/15.
 */
public class StockDAOImpl extends JdbcDaoSupport implements IStockDAO {
    public boolean updateStock(int sid, int scount, boolean isBuy) {
        String sql="";
        int result=0;
        boolean flag=false;
        if (isBuy){
            //买股票
            sql="update stock set scount=scount+? where sid=?";
            result = this.getJdbcTemplate().update(sql, scount, sid);
        }else {
            sql="update stock set scount=scount-? where sid=?";
            // and (select scount from stock where sid=?)>?
            //result = this.getJdbcTemplate().update(sql,scount,sid,sid,scount);
            result = this.getJdbcTemplate().update(sql,scount,sid);
        }
        if (result>0) {
            flag = true;
        }
        return flag;
    }
}
