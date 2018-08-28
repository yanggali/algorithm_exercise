package swardtooffer;

/**
 * 调整数组使得所有奇数在偶数前面
 */
public class AdjustArray {
    public void reOrderArray(int [] array) {
        for (int i = 1; i < array.length;i++){
            int target = array[i];
            if ((target & 1) == 1){
                int j = i;
                while (j >= 1 && (array[j-1] &1) == 0){
                    array[j] = array[j-1];
                    j--;
                }
                array[j] = target;
            }
        }
    }
}
