public class Sort {
    public static void main(String[] args) {
        int[] array = {2,4,1,3,7,5,2};
        heapSort(array);
        print(array);
    }
    public static void print(int[] array){
        for (int i = 0;i < array.length;i++){
            System.out.print(array[i]+" ");
        }
    }

    /**
     * 快速排序
     * @param array
     */
    public static void quickSort(int[] array){
        quickSort(array, 0, array.length-1);
    }
    public static void quickSort(int[] array, int s, int e){
        if (e <= s){
            return;
        }
        int mid = partition(array, s, e);
        if (mid != -1){
            quickSort(array, s, mid - 1);
            quickSort(array, mid+1, e);
        }

    }

    public static int partition(int[] array, int s, int e) {
        int i = s, j = e;
        int temp = array[s];
        while (i < j){
            while (i < j && array[j] >= temp){
                j--;
            }
            while (i < j && array[i] <= temp){
                i++;
            }
            if (i < j){
                int t = array[i];
                array[i] = array[j];
                array[j] = t;
            }
        }
        array[s] = array[i];
        array[i] = temp;
        return i;
    }

    /**
     * 归并排序
     * @param array
     */
    public static void mergeSort(int[] array){
        mergeSort(array, 0, array.length-1);
    }
    public static void mergeSort(int[] array, int s, int e){
        if (s >= e){
            return;
        }
        int mid = (s+e) /2;
        mergeSort(array, s, mid);
        mergeSort(array, mid+1, e);
        merge(array, s,mid,e);
    }
    public static void merge(int[] array, int s, int mid, int e){
        int[] temp = new int[e - s + 1];
        int i = s, j = mid+1, k = 0;
        while (i <= mid && j <= e){
            if (array[i] < array[j]){
                temp[k++] = array[i++];
            }
            else {
                temp[k++] = array[j++];
            }
        }
        while (i <= mid){
            temp[k++] = array[i++];
        }
        while (j <= e){
            temp[k++] = array[j++];
        }
        k = 0;
        for (int l = s;l <= e;l++){
            array[l] = temp[k++];
        }
    }

    /**
     * 堆排序
     * 建立大顶堆
     * 移动root到堆尾
     * 重建大顶堆
     */
    public static void heapSort(int[] array){
        if (array == null) return;
        //从第一个非叶子节点开始从下往上构造最大堆
        for (int i = array.length/2-1; i >= 0; i--) {
            constructHeap(array, i,array.length-1);
        }
        for (int i = array.length-1; i >= 0;i--) {
            swap(array, 0, i);
            constructHeap(array, 0, i);
        }
    }

    //将最大的数放到堆顶
    public static void constructHeap(int[] array, int i, int len){
        if (len-i <= 1) return;
        int j = 0;
        int temp = array[i];
        for (int k = 2*i+1; k < len; k=2*k+1) {
            if (k+1 < len && array[k+1] > array[k]){
                k++;
            }
            if (array[k] > temp){
                array[i] = array[k];
                i = k;
            }
            else {
                break;
            }
        }
        array[i] = temp;
    }
    public static void swap(int[] array, int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
