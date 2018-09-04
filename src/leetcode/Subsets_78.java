package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
    public static void main(String[] args) {
        Subsets_78 s = new Subsets_78();
        int[] nums = {1,2,3};
        List<List<Integer>> list = s.subsets(nums);
        for (List<Integer> all : list) {
            for (Integer num : all) {
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        subsetsHelper(list,temp, nums, 0);
        return list;
    }
    public void subsetsHelper(List<List<Integer>> list, List<Integer> temp, int[] nums, int start){
        list.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            subsetsHelper(list, temp, nums, i+1);
            temp.remove(temp.size()-1);
        }
    }
}
