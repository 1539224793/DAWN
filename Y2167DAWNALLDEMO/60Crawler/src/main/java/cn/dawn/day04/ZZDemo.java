package cn.dawn.day04;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dawn on 2018/3/9.
 */
public class ZZDemo {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("<[a-z|A-Z|0-9|/]+>");
        /*Matcher matcher = pattern.matcher("<html></body>2<3</body><html>");*/
        Matcher matcher = pattern.matcher("ab<1b2>cd<a23>e>");
        //替换第一个符合正则的数据
        System.out.println(matcher.replaceAll(""));
    }

}
