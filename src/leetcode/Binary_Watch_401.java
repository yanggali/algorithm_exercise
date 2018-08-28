package leetcode;

import java.util.ArrayList;
import java.util.List;


public class Binary_Watch_401 {
    public List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<>();
        for (int i = 0;i < 12;i++){
            for(int j = 0;j < 60;j++){
                if (Integer.bitCount(i*64+j) == num){
                    list.add(String.format("%d:%02d", i, j));
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Binary_Watch_401 t = new Binary_Watch_401();
        List<String> l = t.readBinaryWatch2(0);
        System.out.println(l.size());
    }

    public List<String> readBinaryWatch2(int num) {
        int[] num1 = {8, 4, 2, 1}, num2 = {32, 16, 8, 4, 2, 1};
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<String> res = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            list1 = getAllInt(num1, i);
            list2 = getAllInt(num2, num-i);
            for (Integer h : list1) {
                if (h > 11) continue;
                for (Integer m : list2) {
                    if (m > 59) continue;
                    res.add(h + ":" + (m < 10 ? "0" + m : m));
                }
            }
        }
        return res;
    }

    public List<Integer> getAllInt(int[] num, int count){
        List<Integer> list = new ArrayList<>();
        getAllIntList(num , count, 0, 0, list);
        return list;
    }

    public void getAllIntList(int[] num , int count, int startindex, int sum, List<Integer> res){
        if (count == 0){
            res.add(sum);
        }
        else {
            for (int i = startindex; i < num.length; i++) {
                getAllIntList(num, count-1,i+1,sum+num[i], res);
            }
        }
    }
}
