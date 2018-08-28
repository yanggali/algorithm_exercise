package leetcode;

public class Arithmetic_Slices_413 {
    public static int numberOfArithmeticSlices(int[] A) {
        int count = 0;
        int addend = 0;

        for (int i = 2; i < A.length; i++)
            if (A[i - 1] - A[i] == A[i - 2] - A[i - 1])
                count += ++addend;
            else
                addend = 0;

        return count;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,5};
        System.out.println(numberOfArithmeticSlices(a));
    }
}
