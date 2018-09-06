package leetcode;

/**
 * 判断字符串是否能被其子串重复n次相等
 * 使用了正则表达式匹配的方法
 * Pattern.matches(p,s)判断s是否能被p完全匹配
 */

import java.util.regex.Pattern;

public class Repeated_Substring_Pattern_459 {
    public static void main(String[] args) {
        //System.out.println(4>>1);
        Repeated_Substring_Pattern_459 r = new Repeated_Substring_Pattern_459();
        System.out.println(r.repeatedSubstringPattern("babbabbabbabbab"));
    }
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length() >> 1;
        boolean flag = false;
        for (int i = 1; i <= len; i++) {
            if (s.length() % i != 0) continue;
            if (Pattern.matches("("+s.substring(0, i)+")+", s)){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
