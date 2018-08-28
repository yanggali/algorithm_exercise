package swardtooffer;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci temp = new Fibonacci();
        System.out.println(temp.Fibonacci(3));
    }
    public int Fibonacci(int n) {
        if (n == 0 || n == 1){
            return n;
        }
        int first = 0, second = 1, numN = 0;
        for (int i = 2;i <= n; i++){
            numN = first + second;
            first = second;
            second = numN;
        }
        return numN;
    }
}
