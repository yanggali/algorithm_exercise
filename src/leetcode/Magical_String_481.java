package leetcode;

/**
 * 求魔法数前n个数字中有几个1
 * index是判断有几位的位置，i是需要设置数值的位置，i会走的比index快
 */
public class Magical_String_481 {
    public static void main(String[] args) {
        Magical_String_481 m = new Magical_String_481();
        System.out.println(m.magicalString(6));
    }
    public int magicalString(int n) {
        if (n <= 1) return n;
        int[] m = new int[n];
        m[0] = 1;
        m[1] = 2;
        int index = 1, count = 1;
        boolean isone = false;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= m[i]; j++) {
                if (index >= n) break;
                if (isone) {
                    m[index] = 1;
                    count++;
                } else m[index] = 2;
                index++;
            }
            isone = !isone;
        }
        return count;
    }

}
