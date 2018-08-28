package swardtooffer;

public class NumberOf1 {
    public int NumberOf1(int n) {
        if (n == 0){
            return 0;
        }
        int flag = 1, count = 0;
        while (flag != 0){
            if ((n & flag) != 0){
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }
}
