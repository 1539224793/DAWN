package cn.dawn.day03printer.printer;

import cn.dawn.day03printer.ink.Ink;
import cn.dawn.day03printer.paper.Paper;

/**
 * Created by Dawn on 2018/3/3.
 */
/*打印机*/
public class Printer {
    /*墨盒*/
    private Ink ink;
    /*纸张*/
    private Paper paper;
    /*打印方法*/
    public void print(){
        System.out.println("我们的喷墨打印机，用"+ink.getInkColor()+"和"+paper.getPagerSize()+"打印出了------》我爱Spring");
    }


    public Ink getInk() {
        return ink;
    }

    public void setInk(Ink ink) {
        this.ink = ink;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }
}
