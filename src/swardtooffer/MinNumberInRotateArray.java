package swardtooffer;

public class MinNumberInRotateArray {
    public static void main(String[] args) {
        MinNumberInRotateArray temp = new MinNumberInRotateArray();
        int[] array = {2,2,2,1,2};
        System.out.println(temp.minNumberInRotateArray(array));
    }
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0){
            return 0;
        }
        return minNum(array, 0, array.length-1);
    }
    public int minNum(int[] array, int start, int end){
        if (start >= end || array[start] < array[end]){
            return array[start];
        }

        int mid = (start + end) / 2;
        if (array[mid] > array[start]){
            return minNum(array, mid+1, end);
        }
        else if (array[mid] < array[start]){
            return minNum(array, start, mid);
        }
        else{
            return minNum(array, start, mid-1) > minNum(array, mid+1, end)
                    ? minNum(array, mid+1, end) : minNum(array, start, mid-1);
        }
    }
}
