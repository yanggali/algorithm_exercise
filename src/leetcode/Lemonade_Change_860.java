package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Lemonade_Change_860 {
    public static void main(String[] args) {
        Lemonade_Change_860 t = new Lemonade_Change_860();
        int[] array = {5,5,5,10,20};
        System.out.println(t.lemonadeChange(array));
    }
    public boolean lemonadeChange(int[] bills) {
        if (bills.length < 1) return true;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(5,0);
        map.put(10,0);
        map.put(20,0);
        for (int i = 0;i < bills.length;i++){
            if (bills[i] == 5){
                map.put(5, map.get(5)+1);
            }
            else if (bills[i] == 10){
                if (map.get(5) > 0){
                    map.put(5,map.get(5) - 1);
                    map.put(10, map.get(10)+1);
                }
                else {
                    return false;
                }
            }
            else {
                if (map.get(10) > 0 && map.get(5) > 0){
                    map.put(10, map.get(10) -1);
                    map.put(5, map.get(5)-1);
                    map.put(20, map.get(20)+1);
                }
                else if (map.get(5) > 2){
                    map.put(5, map.get(5)-3);
                    map.put(20, map.get(20)+1);
                }
                else return false;
            }
        }
        return true;
    }
}
