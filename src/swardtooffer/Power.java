package swardtooffer;

public class Power {
    public double Power(double base, int exponent) {
        if (base == 0){
            return 0;
        }

        double power = 1;
        if (exponent == 0){
            return 1;
        }

        if (exponent > 0){
            while (exponent != 0){
                power *= base;
                exponent--;
            }
            return power;
        }
        else {
            while (exponent != 0){
                power *= base;
                exponent++;
            }
            return 1.0/power;
        }
    }
}
