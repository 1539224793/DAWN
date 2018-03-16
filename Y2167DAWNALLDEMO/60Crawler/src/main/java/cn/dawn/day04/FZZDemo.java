package cn.dawn.day04;

/**
 * Created by Dawn on 2018/3/9.
 */
public class FZZDemo {
    public static void main(String[] args) {
        System.out.println(getStr("<<<a>ab<b>>>"));
    }
    public static String getStr(String str) {
        char[] strs = str.toCharArray();
        int numl = 0;
        int num2 = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == '<') {
                numl = i;
                for (int j = 0; j < strs.length; j++) {
                    if (strs[j] == '<') {
                        numl = j;
                    }
                    if (strs[j] == '>') {
                        num2 = j;
                        break;
                    }

                }
                for (int j = numl; j <= num2; j++) {
                    strs[j] = ' ';

                }
            }
        }
        String a="";
        for (int i=0;i<strs.length;i++){
            if(strs[i]!=' '){
                a+=strs[i];
            }
        }
        return a;
    }
}