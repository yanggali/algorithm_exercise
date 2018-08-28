package swardtooffer;

public class OneTimeWord {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int len = array.length;
        int diff = 0;
        for (int i = 0; i < len;i++){
            diff ^= array[i];
        }
        int index = getFirstOne(diff);
        for (int j = 0; j < len;j++){

        }
    }
    public int getFirstOne(int diff){
        int index = 0;
        while ((diff & 0x1) == 0 && index < Integer.SIZE){
            diff >>= 1;
            index++;
        }
        return index;
    }
}
