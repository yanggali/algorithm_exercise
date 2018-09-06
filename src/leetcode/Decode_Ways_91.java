package leetcode;

/**
 *  求数字字符串的所有编码方式的个数
 */
public class Decode_Ways_91 {
    public static void main(String[] args) {
        Decode_Ways_91 t = new Decode_Ways_91();
        System.out.println(t.numDecodings("27"));
    }
    public int numDecodings(String s) {
        int[] L = new int[s.length()+1];
        L[s.length()] = 1;
        L[s.length()-1] = s.charAt(s.length()-1) == '0' ? 0:1;
        for (int i = s.length()-2; i >= 0; i--) {
            if (s.charAt(i) == '0') continue;
            else {
                L[i] = Integer.parseInt(s.substring(i,i+2)) < 27 ? L[i+1]+L[i+2] : L[i+1];
            }
        }
        return L[0];
    }
}
