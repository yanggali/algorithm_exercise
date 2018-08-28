package leetcode;

public class Peak_Index_in_a_Mountain_Array_852 {
    public int peakIndexInMountainArray(int[] A) {
        int s = 0, e = A.length-1;
        while (s != e){
            int mid = (s+e) / 2;
            if (A[mid] > A[mid+1] && A[mid] > A[mid-1]){
                return mid;
            }
            else if (A[mid] > A[mid-1] && A[mid] < A[mid+1]){
                s = mid + 1;
            }
            else {
                e = mid - 1;
            }
        }
        return s;
    }
}
