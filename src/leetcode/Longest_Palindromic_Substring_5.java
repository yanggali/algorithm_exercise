package leetcode;

/**
 * 求最长回文子串
 */
public class Longest_Palindromic_Substring_5 {
    public static void main(String[] args) {
        //System.out.println("ab".substring(0,1));
        Longest_Palindromic_Substring_5 l = new Longest_Palindromic_Substring_5();
        System.out.println(l.longestPalindrome(""));
    }
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";
        char[] array = s.toCharArray();
        int len = array.length;
        int left = 0, right = 0, max = 1;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                //本题的关键在于要
                dp[j][i] = (array[i] == array[j]) && (i - j < 2 || dp[j+1][i-1]);
                if (dp[j][i]&&i-j+1 > max){
                    left = j;
                    right = i;
                    max = i-j+1;
                }
            }
            dp[i][i] = true;
        }
        return s.substring(left, right+1);
    }
}
