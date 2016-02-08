package code.demoutils.sortutils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anayonkar on 8/2/16.
 */
public class QuickSort {
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
    public static List<Integer> quickSort(final List<Integer> input) {
        if(input.size() < 2) {
            return input;
        }
        final int pivotIndex = input.size() / 2;
        final Integer pivot = input.get(pivotIndex);
        final List<Integer> lower = new ArrayList<>();
        final List<Integer> higher = new ArrayList<>();
        int count = 0;
        for(int number : input) {
            if(count++ == pivotIndex)   continue;
            if(number < pivot) {
                lower.add(number);
            } else {
                higher.add(number);
            }
        }
        final List<Integer> result = quickSort(lower);
        result.add(pivot);
        result.addAll(quickSort(higher));
        return result;
    }
    public static void main(String[] args) {
        System.out.println(list);
        System.out.println(quickSort(list));
    }
}
