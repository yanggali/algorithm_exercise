package leetcode;

public class Factorial_Trailing_Zeroes_172 {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(10));
    }
    public static int trailingZeroes(int n) {
        int count = 0,temp = 1;
        while (n > 0){
            count += n/5;
            n/=5;
        }
        return count;
    }
}
