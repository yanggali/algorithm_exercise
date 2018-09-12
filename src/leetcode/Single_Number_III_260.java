package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 查找只出现一次的数字
 */
public class Single_Number_III_260 {
    public static void main(String[] args) {
        int num = 3;
        System.out.println(num &= -num);
    }

    /**
     * 方法一：利用hashmap
     */
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = map.getOrDefault(nums[i], 0)+1;
            map.put(nums[i], n);
        }
        int[] res = new int[2];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == 1){
                res[count++] = nums[i];
            }
        }
        return res;
    }

    /**
     *方法二：利用位操作
     * diff &= -diff是diff最低的1
     */
    public int[] singleNumber1(int[] nums){
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        diff &= -diff;
        int[] res = {0,0};
        for (int num : nums) {
            if ((num & diff) == 0){
                res[0] ^= num;
            }
            else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
