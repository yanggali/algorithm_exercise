package swardtooffer;

public class FrogJump {
    public int JumpFloor(int target) {
        if (target == 0){
            return 0;
        }
        if (target == 1){
            return 1;
        }
        if (target == 2){
            return 2;
        }
        int sum = 0, onestep = 1, twostep = 2;
        for (int i = 3; i <= target ;i++){
            sum = onestep + twostep;
            onestep = twostep;
            twostep = sum;
        }
        return sum;
    }
}
