package cn.dawn.day22tx.entity;

/**
 * Created by Dawn on 2018/3/15.
 */
public class StockException extends ClassNotFoundException {
    public StockException() {
    }

    public StockException(String s) {
        super(s);
    }
}
