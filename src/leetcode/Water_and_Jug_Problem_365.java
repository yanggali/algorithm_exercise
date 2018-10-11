package leetcode;

/**
 * 水桶计量问题
 * 两个水桶的容量分别为x,y，求用他们是否能测量出容量为z的水
 * 若mx+ny=z，则能找到
 */
public class Water_and_Jug_Problem_365 {
    public static void main(String[] args) {
        Water_and_Jug_Problem_365 w = new Water_and_Jug_Problem_365();
        System.out.println(w.canMeasureWater(3,5,4));
    }
    public boolean canMeasureWater(int x, int y, int z) {
        return x+y == z || (x+y > z && z % gcd(x,y) == 0);
    }
    //求最大公约数
    public int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a%b);
    }
}
