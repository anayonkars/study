package code.demoutils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ANAYONKS on 09/02/2016.
 */
public class FibonacciDemo {
    private static Map<Long, Long> cache = new HashMap<>();
    public static void main(String[] args) {
        long number = 50;
        long start = System.nanoTime();
        System.out.println(simpleFibonacci(number));
        System.out.println("Time : " + (System.nanoTime() - start));
        start = System.nanoTime();
        System.out.println(cacheFibonacci(number));
        System.out.println("Time : " + (System.nanoTime() - start));
    }
    public static long simpleFibonacci(long n) {
        validateInput(n);
        return n == 0 ? 0 : n == 1 ? 1 : simpleFibonacci(n - 1) + simpleFibonacci(n - 2);
    }
    public static long cacheFibonacci(long n) {
        if(n == 0 || n == 1) {
            cache.put(n, n);
            return n;
        }
        Long result = cache.get(n);
        if(result == null) {
            result = cacheFibonacci(n - 1) + cacheFibonacci(n - 2);
            cache.put(n, result);
        }
        return result;
    }
    private static void validateInput(long n) {
        if(n < 0) {
            throw new IllegalArgumentException("Illegal input");
        }
    }
}
