package code.demoutils.sortutils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anayonkar on 8/2/16.
 */
public class MergeSort {
    private static final int[] arr = {3, 4, 2, 1, 7, 5, 8, 9, 0, 6};
    private static final List<Integer> list = new ArrayList<>();
    static {
        list.add(3);
        list.add(4);
        list.add(2);
        list.add(1);
        list.add(7);
        list.add(5);
        list.add(8);
        list.add(9);
        list.add(0);
        list.add(6);
    }
    public static List<Integer> mergeSort(final List<Integer> input) {
        if(input.size() < 2) {
            return input;
        }
        final List<Integer> left = input.subList(0, input.size() / 2);
        final List<Integer> right = input.subList(input.size() / 2, input.size());
        return merge(mergeSort(left), mergeSort(right));
    }
    private static List<Integer> merge(final List<Integer> left, final List<Integer> right) {
        final List<Integer> result = new ArrayList<>(left.size() + right.size());
        int leftIndex = 0;
        int rightIndex = 0;
        while(leftIndex < left.size() && rightIndex < right.size()) {
            if(left.get(leftIndex) < right.get(rightIndex)) {
                result.add(left.get(leftIndex));
                leftIndex++;
            } else {
                result.add(right.get(rightIndex));
                rightIndex++;
            }
        }
        while (leftIndex < left.size()) {
            result.add(left.get(leftIndex));
            leftIndex++;
        }
        while (rightIndex < right.size()) {
            result.add(right.get(rightIndex));
            rightIndex++;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(list);
        System.out.println(mergeSort(list));
    }
}
