package cn.dawn.day22tx.dao;

/**
 * Created by Dawn on 2018/3/15.
 */
public interface IStockDAO {
    public boolean updateStock(int sid,int scount,boolean isBuy);
}
