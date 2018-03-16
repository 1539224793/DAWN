package cn.dawn.day22tx.service;

import cn.dawn.day22tx.entity.StockException;

/**
 * Created by Dawn on 2018/3/15.
 */
public interface IStockPayService {
    public boolean buyStock(int aid,int ablance,int sid,int scount) throws StockException;
}
