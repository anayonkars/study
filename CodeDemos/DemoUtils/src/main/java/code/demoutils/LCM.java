package code.demoutils;

/**
 * Created by anayonkar on 16/5/17.
 */
public class LCM {
    public static int lcm(int x, int y) {
        return (x * y)/GCD.gcd(x, y);
    }

    public static int lcmOther(int x, int y) {
        int a = x > y ? x : y;
        while(true) {
            if(a % x == 0 && a % y == 0) {
                return a;
            }
            ++a;
        }
    }
}
