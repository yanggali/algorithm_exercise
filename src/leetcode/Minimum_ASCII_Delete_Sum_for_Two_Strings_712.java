package leetcode;

public class Minimum_ASCII_Delete_Sum_for_Two_Strings_712 {
    public int minimumDeleteSum(String s1, String s2) {
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        int[][] dp = new int[s1Array.length+1][s2.length()+1];
        for (int i = 1; i <= s1.length();i++){
            dp[i][0] += dp[i-1][0] + s1Array[i-1];
        }
        for (int j = 1; j <= s2.length();j++){
            dp[0][j] += dp[0][j-1] + s2Array[j-1];
        }
        for (int m = 1; m <= s1.length();m++){
            for (int n = 1; n <= s2.length(); n++){
                if (s1Array[m-1] == s2Array[n-1]){
                    dp[m][n] = dp[m-1][n-1];
                }
                else {
                    dp[m][n] = Math.min(dp[m-1][n] + s1Array[m-1], dp[m][n-1] + s2Array[n-1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
