package leetcode;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 最长递增子序列
 */
public class Longest_Increasing_Subsequence_300 {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,4};
        System.out.println(lengthOfLIS2(nums));
    }
    public static int lengthOfLIS(int[] nums) {
        if (nums.length <= 0) return 0;
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        int maxlen = 1;
        for (int i = 1; i < len;i++){
            for (int j = 0;j < i;j++){
                if (nums[j] < nums[i]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
            maxlen = Math.max(maxlen, dp[i]);
        }
        return maxlen;
    }

    public static int lengthOfLIS2(int[] nums) {
        if (nums.length < 1) return 0;
        List<Integer> s = new ArrayList<>();
        int maxlen = 1;

        for (int i = 0;i < nums.length;i++){
            if (s.isEmpty() || s.get(s.size()-1) < nums[i]){
                s.add(nums[i]);

            }
            else {
                int start = 0, end = s.size()-1;
                while (start < end){
                    int mid = (start+end) / 2;
                    if (s.get(mid) < nums[i]){
                        start = mid+1;
                    }
                    else {
                        end = mid - 1;
                    }
                }
                s.set(start, nums[i]);
            }
        }
        return s.size();
    }
}
