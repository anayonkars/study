package code.demoutils.sortutilswitharrays;

import java.util.Arrays;

/**
 * Created by anayonkar on 1/2/16.
 */
public class SelectionSort {
    private static final int[] arr = {64, 25, 12, 22, 11};
    public static int[] selectionSort(int[] input) {
        //return selectionSort(input, 0);
        return selectionSortNonRecursive(input);
    }
    private static int[] selectionSort(int[] input, int start) {
        if(start < input.length - 1) {
            swap(input, start, findMinimumIndex(input, start));
            selectionSort(input, start + 1);
        }
        return input;
    }
    private static int[] selectionSortNonRecursive(int[] input) {
        for(int start = 0 ; start < input.length -1 ; start++) {
            swap(input, start, findMinimumIndex(input, start));
        }
        return input;
    }
    private static int findMinimumIndex(int[] input, int start) {
        int minPos = start;
        for(int i = start + 1 ; i < input.length ; ++i) {
            if(input[i] < input[minPos]) {
                minPos = i;
            }
        }
        return minPos;
    }
    private static void swap(int[] input, int index1, int index2) {
        if(index1 != index2) {
            int temp = input[index1];
            input[index1] = input[index2];
            input[index2] = temp;
        }
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(selectionSort(arr)));
    }
}
