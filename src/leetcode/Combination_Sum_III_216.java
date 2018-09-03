package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Combination_Sum_III_216 {
    public static void main(String[] args) {
        Combination_Sum_III_216 s = new Combination_Sum_III_216();
        List<List<Integer>> list = s.combinationSum3(3, 9);
        for (List<Integer> a : list) {
            for (Integer num : a) {
                System.out.print(num);
            }
            System.out.println();
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        combinationSum3Helper(list,path,k,1,n);
        return list;
    }
    public void combinationSum3Helper(List<List<Integer>> list, List<Integer> path, int k, int start, int sum){
        if (sum == 0 && k == 0){
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= 9; i++) {
            path.add(i);
            combinationSum3Helper(list, path,k-1,i+1, sum-i );
            path.remove(path.size()-1);
        }
    }
}
