package leetcode;

/**
 * 求最长的没有重复元素的子串
 */
public class Longest_Substring_Without_Repeating_Characters_3 {
    public static void main(String[] args) {
        Longest_Substring_Without_Repeating_Characters_3 l = new Longest_Substring_Without_Repeating_Characters_3();
        System.out.println(l.lengthOfLongestSubstring("dvdf"));
    }
    public int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        int len = s.length();
        int[] dp = new int[len];
        String max = "";
        int maxlen = 0, templen = 0;
        for (int i = 0; i < array.length; i++) {
            int lastindex = max.indexOf(array[i]);
            if (lastindex==-1){
                max += array[i];
                templen++;
            }
            else {
                max = max.substring(lastindex+1)+array[i];
                templen = max.length();
            }
            maxlen = Math.max(maxlen, templen);
        }
        return maxlen;
    }
}
