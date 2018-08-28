package swardtooffer;

public class RectCover {
    public int RectCover(int target) {
        if (target == 0){
            return 0;
        }
        if (target == 1){
            return 1;
        }
        if (target == 2){
            return 2;
        }
        int sum = 0, one = 1, two = 2;
        for (int i = 3; i <= target; i++){
            sum = one + two;
            one = two;
            two = sum;
        }
        return sum;
    }
}
