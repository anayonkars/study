package code.demoutils.sortutils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by anayonkar on 8/2/16.
 */
public class InsertionSort {
    private static final List<Integer> list = new ArrayList<>();
    static {
        list.add(3);
        list.add(7);
        list.add(4);
        list.add(9);
        list.add(5);
        list.add(2);
        list.add(6);
        list.add(1);
    }
    public static List<Integer> insertionSort(final List<Integer> input) {
        final List<Integer> result = new LinkedList<>();
        outerLoop:
        for(Integer number : input) {
            for (int i = 0 ; i < result.size() ; i++) {
                if(number < result.get(i)) {
                    result.add(i, number);
                    continue outerLoop;
                }
            }
            result.add(result.size(), number);
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(list);
        System.out.println(insertionSort(list));
    }
}
