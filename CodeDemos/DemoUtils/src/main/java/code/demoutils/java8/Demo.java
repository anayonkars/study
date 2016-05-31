package code.demoutils.java8;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by ANAYONKS on 17/03/2016.
 */
public class Demo {

    public static Map<String, Long> charCount(String input) {
        //Stream.of(input.split("")).flatMap(Arrays::stream).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        /*Stream<String> stream = Stream.of(input.split(""));
        return stream.filter(t -> !" ".equals(t)).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));*/
        return Stream.of(input.split(""))
                .filter(t -> !" ".equals(t))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static Map<String, Long> wordCount(String input) {
        return Stream.of(input.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static Map<Integer, List<String >> mapByLength(String input) {
        return Stream.of(input.split(" "))
                .collect(Collectors.groupingBy(String::length));
    }

    public static boolean isGreaterThan3(int number) {
        System.out.println("isGreaterThan called for " + number);
        return number > 3;
    }

    public static boolean isEven(int number) {
        System.out.println("isEven called for " + number);
        return number % 2 == 0;
    }

    public static int doubleIt(int number) {
        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("doubleIt called for " + number);
        return number * 2;
    }

    public static int totalValues(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream()
                        .filter(condition)
                        .reduce(0, Math::addExact);
    }

    public static void main(String[] args) {
        String input = "hello world hello hello world abcd abc abcd abc";
        System.out.println(charCount(input));
        System.out.println(wordCount(input));
        System.out.println(mapByLength(input));
        System.out.println(isPrime(1));
        System.out.println(isPrime(2));
        System.out.println(isPrime(3));
        System.out.println(isPrime(4));
        List<Integer> values = Arrays.asList(1,2,3,5,4,6,7,8,9,10);
        int result = 0;
        for(int x : values) {
            if(x > 3 && x % 2 == 0) {
                result = x * 2;
                break;
            }
        }
        System.out.println(result);
        Predicate<Integer> isGT3 = number -> number > 3;
        Function<Integer, Predicate<Integer>> isGreaterThan = pivot ->
                number -> number > pivot;
        result = values.stream()
                    .filter(/*x -> x > 3*//*Demo::isGreaterThan3*//*isGT3*/isGreaterThan.apply(3))
                    .filter(/*x -> x % 2 == 0*/Demo::isEven)
                    .map(/*x -> x * 2*/Demo::doubleIt)
                    .findFirst()
                    .get();
        System.out.println(result);
        System.out.println(totalValues(values, e -> true));
        System.out.println(totalValues(values, e -> e % 2 == 0));
        System.out.println(
                values.stream()
                        .mapToInt(Demo::doubleIt)
                        .sum());
        System.out.println(
                values.parallelStream()
                        .mapToInt(Demo::doubleIt)
                        .sum()
        );
    }

    private static boolean isPrime(int number) {
        /*for(int i = 2 ; i < number ; i++) {
            if(number % i == 0) return false;
        }
        return number > 1;*/
        IntPredicate isDivisible = divisor -> number % divisor == 0;
        return number > 1 &&
                IntStream.range(2, number)
                    /*.noneMatch(i -> number % i == 0);*/
                    .noneMatch(isDivisible);
    }
}
