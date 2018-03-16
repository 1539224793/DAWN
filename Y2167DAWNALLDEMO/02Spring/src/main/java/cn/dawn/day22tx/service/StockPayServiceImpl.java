package cn.dawn.day22tx.service;

import cn.dawn.day22tx.dao.IAccountDAO;
import cn.dawn.day22tx.dao.IStockDAO;
import cn.dawn.day22tx.entity.StockException;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Dawn on 2018/3/15.
 */
public class StockPayServiceImpl implements IStockPayService {
    IStockDAO iStockDAO;
    IAccountDAO iAccountDAO;
    //@Transactional(rollbackFor = StockException.class)
    public boolean buyStock(int aid, int ablance, int sid, int scount) throws StockException {
        boolean isBuy=true;
        boolean sflag = iStockDAO.updateStock(sid, scount, isBuy);

        if(true){
            throw new StockException("网络被挂掉异常");
        }

        boolean aflag = iAccountDAO.updateAccount(aid, ablance, isBuy);

        if(sflag&&aflag)
            return true;
        else
            return false;
    }

    public IStockDAO getiStockDAO() {
        return iStockDAO;
    }

    public void setiStockDAO(IStockDAO iStockDAO) {
        this.iStockDAO = iStockDAO;
    }

    public IAccountDAO getiAccountDAO() {
        return iAccountDAO;
    }

    public void setiAccountDAO(IAccountDAO iAccountDAO) {
        this.iAccountDAO = iAccountDAO;
    }
}
