package code.demoutils.sortutils;

import java.util.Arrays;

/**
 * Created by ANAYONKS on 02/02/2016.
 */
public class QuickSortOptimized {
    private static final int[] arr = {3, 7, 8, 5, 2, 1, 9, 5, 4};
    public static int[] quickSortOptimized(int[] input) {
        return quickSortOptimized(input, 0, input.length - 1);
    }
    private static int[] quickSortOptimized(int[] input, int left, int right) {
        int pivotValue = input[(left + right) / 2];
        int i = left;
        int j = right;
        while(i <= j) {
            while (input[i] < pivotValue) i++;
            while (input[j] > pivotValue) j--;
            if(i <= j) {
                swap(input, i, j);
                i++;
                j--;
            }
        }
        if(left < j) {
            quickSortOptimized(input, left, j);
        }
        if(i < right) {
            quickSortOptimized(input, i, right);
        }
        return input;
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
        System.out.println(Arrays.toString(quickSortOptimized(arr)));
    }
}
