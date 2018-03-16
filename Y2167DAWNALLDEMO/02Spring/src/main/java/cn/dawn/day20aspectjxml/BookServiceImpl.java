package cn.dawn.day20aspectjxml;

/**
 * Created by Dawn on 2018/3/12.
 */
public class BookServiceImpl implements IBookService {
    public void selectAllBooks() {
        System.out.println("selectbooks ok");

        int a=5/0;
        System.out.println(a);
    }
}
