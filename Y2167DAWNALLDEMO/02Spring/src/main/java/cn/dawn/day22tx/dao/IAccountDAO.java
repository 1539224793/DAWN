package cn.dawn.day22tx.dao;

/**
 * Created by Dawn on 2018/3/15.
 */
public interface IAccountDAO {
    public boolean updateAccount(int aid,int ablance,boolean isBuy);
}
