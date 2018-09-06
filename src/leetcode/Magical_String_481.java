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
        if (n == 0) return 0;
        else if (n <= 3) return 1;
        int[] num = new int[n];
        num[0] = 1;
        num[1] = 2;
        boolean isone = false;
        int index = 1, result = 1;
        for (int i = 1;i < n;i++){
            for (int j = num[index]; j > 0; j--) {
                if (i >= n) break;
                num[i] = isone ? 1 : 2;
                i++;
                if (isone) {
                    result++;
                }
            }
            index++;
            i--;
            isone = !isone;
        }
        return result;
    }

}
