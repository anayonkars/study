package code.demoutils.sortutils;

import java.util.Arrays;

/**
 * Created by anayonkar on 1/2/16.
 */
public class QuickSort {
    private static final int[] arr = {3, 7, 8, 5, 2, 1, 9, 5, 4};
    public static int[] quickSort(int[] input) {
        if(input.length < 2) {
            return input;
        }
        int pivotIndex = input.length / 2;
        int pivotValue = input[pivotIndex];
        int leftCount = 0;
        for(int i = 0 ; i < input.length ; ++i) {
            if(input[i] < pivotValue) ++leftCount;
        }
        int[] left = new int[leftCount];
        int[] right = new int[input.length - leftCount - 1];
        int l = 0;
        int r = 0;
        for(int i = 0 ; i < input.length ; ++i) {
            if(i == pivotIndex) continue;
            int value = input[i];
            if(value < pivotValue) {
                left[l++] = value;
            } else {
                right[r++] = value;
            }
        }
        left = quickSort(left);
        right = quickSort(right);
        System.arraycopy(left, 0, input, 0, left.length);
        input[left.length] = pivotValue;
        System.arraycopy(right, 0, input, left.length + 1, right.length);
        return input;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(quickSort(arr)));
    }
}
