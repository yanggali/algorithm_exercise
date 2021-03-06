package leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Permutations_46 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permutations_46 p = new Permutations_46();
        List<List<Integer>> list = p.permute(nums);
        for (List<Integer> all : list) {
            for (Integer num : all) {
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> permute = new ArrayList<>();
        int[] visited = new int[nums.length];
        permuteHelper(visited, nums, permute, list);
        return list;
    }
    public void permuteHelper(int[] visited,int[] nums, List<Integer> permute, List<List<Integer>> list){
        if (permute.size() == visited.length){
            list.add(new ArrayList<>(permute));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 0){
                permute.add(nums[i]);
                visited[i] = 1;
                permuteHelper(visited, nums, permute, list);
                permute.remove(permute.size()-1);
                visited[i] = 0;
            }
        }
    }
}
