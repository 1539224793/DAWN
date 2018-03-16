package cn.dawn.day22tx.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by Dawn on 2018/3/15.
 */
public class AccountDAOImpl extends JdbcDaoSupport implements IAccountDAO {
    public boolean updateAccount(int aid, int ablance, boolean isBuy) {
        String sql="";
        boolean flag=false;
        int count=0;
        if(isBuy){
            //买股票
            sql="update account set ablance=ablance-? where aid=?";
//            and (select ablance FROM account where aid=?)>?
//            count = this.getJdbcTemplate().update(sql, ablance, aid, aid, ablance);
            count = this.getJdbcTemplate().update(sql, ablance, aid);
        }else {
            sql="update account set ablance=ablance+? where aid=?";
            count = this.getJdbcTemplate().update(sql, ablance, aid);
        }
        if(count>0){
            flag=true;
        }
        return flag;
    }
}
