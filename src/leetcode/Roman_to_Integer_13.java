package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Roman_to_Integer_13 {
    public static void main(String[] args) {
        Roman_to_Integer_13 t = new Roman_to_Integer_13();
        System.out.println(t.romanToInt("MCMXCIV"));
    }
    public static Map<String ,Integer> map = new HashMap<String, Integer>(){{
        put("I", 1);
        put("V",5);
        put("X", 10);
        put("L", 50);
        put("C", 100);
        put("D", 500);
        put("M", 1000);
        put("IV", 4);
        put("IX",9);
        put("XL", 40);
        put("XC", 90);
        put("CD", 400);
        put("CM", 900);
    }};
    public int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.toCharArray().length;) {
            if (i+1 < s.length() &&  map.containsKey(s.substring(i, i+2))){
                sum += map.get(s.substring(i,i+2));
                i+=2;
            }
            else {
                sum += map.get(String.valueOf(s.charAt(i)));
                i++;
            }
        }
        return sum;
    }
}
