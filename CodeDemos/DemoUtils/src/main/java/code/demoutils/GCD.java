package code.demoutils;

/**
 * Created by anayonkar on 16/5/17.
 */
public class GCD {
    public static int gcd(int x, int y) {
        int a = x > y ? x : y;
        int b = x < y ? x : y;
        int r = b;
        while(a % b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return r;
    }

    public static int gcdOther(int x, int y) {
        if(y == 0) {
            return x;
        }
        return gcdOther(y, x%y);
    }
}
