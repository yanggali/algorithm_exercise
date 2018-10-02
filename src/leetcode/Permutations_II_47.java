package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations_II_47 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        Permutations_II_47 p = new Permutations_II_47();
        List<List<Integer>> list = p.permuteUnique(nums);
        for (List<Integer> all : list) {
            for (Integer num : all) {
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 1){
            return list;
        }
        //先对数组进行排序
        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        List<Integer> permutate = new ArrayList<>();
        permuteUniqueHelper(list, visited, permutate, nums);
        return list;
    }
    public void permuteUniqueHelper(List<List<Integer>> list, int[] visited, List<Integer> permutate, int[] nums){
        if (permutate.size() == nums.length){
            list.add(new ArrayList<>(permutate));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;
            //对于有重复的数，保证他们的稳定性，如果已经以前一位数作为开头遍历了，那么就不再遍历以后面的数开头的情况了
            if (i > 0 && nums[i-1] == nums[i] && visited[i-1] == 0) continue;
            visited[i] = 1;
            permutate.add(nums[i]);
            permuteUniqueHelper(list, visited, permutate, nums);
            permutate.remove(permutate.size()-1);
            visited[i] = 0;

        }
    }
}
