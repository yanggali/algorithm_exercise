package swardtooffer;

public class FrogJumpTwo {
    public int JumpFloorII(int target) {
        if (target == 0 || target == 1){
            return 1;
        }
        return 2*JumpFloorII(target-1);
    }
}
