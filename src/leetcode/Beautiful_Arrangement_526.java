package leetcode;

public class Beautiful_Arrangement_526 {
    public int count = 0;
    public int countArrangement(int N) {
        if (N ==0) return 0;
        countArrangementHelper(1, N, new int[N+1]);
        return count;
    }

    public void countArrangementHelper(int index, int N, int[] array){
        if (index > N){
            count++;
            return;
        }
        else {
            for (int i = 1; i <= N; i++) {
                if (array[i] == 0 && (i % index == 0 || index % i == 0)){
                    array[i] = 1;
                    countArrangementHelper(index+1, N, array);
                    array[i] = 0;
                }
            }
        }
    }
}
