package leetcode;

import java.util.HashMap;
import java.util.Map;

public class FourSum_II_454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int i1 = 0; i1 < B.length; i1++) {
                int sum = A[i] + B[i1];
                map.put(sum,map.getOrDefault(sum,0) +1 );
            }
        }
        int count = 0;
        for (int i = 0; i < C.length; i++) {
            for (int i1 = 0; i1 < D.length; i1++) {
                count += map.getOrDefault(-1*(C[i] + D[i1]),0);
            }
        }
        return count;
    }
}
