package code.demoutils.sortutilswitharrays;

import java.util.Arrays;

/**
 * Created by anayonkar on 1/2/16.
 */
public class MergeSort {
    private static final int[] arr = {3, 4, 2, 1, 7, 5, 8, 9, 0, 6};
    public static int[] mergeSort(int[] input) {
        if(input.length < 2) {
            return input;
        }
        int middle = input.length / 2;
        int[] left = new int[middle];
        int[] right = new int[input.length - middle];
        System.arraycopy(input, 0, left, 0, left.length);
        System.arraycopy(input, middle, right, 0, right.length);
        mergeSort(left);
        mergeSort(right);
        return merge(input, left, right);
    }
    private static int[] merge(int[] result, int[] left, int[] right) {
        int resultIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while(leftIndex < left.length && rightIndex < right.length) {
            if(left[leftIndex] <= right[rightIndex]) {
                result[resultIndex++] = left[leftIndex++];
            } else {
                result[resultIndex++] = right[rightIndex++];
            }
        }
        while(leftIndex < left.length) {
            result[resultIndex++] = left[leftIndex++];
        }
        while(rightIndex < right.length) {
            result[resultIndex++] = right[rightIndex++];
        }
        return  result;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(mergeSort(arr)));
    }
}
