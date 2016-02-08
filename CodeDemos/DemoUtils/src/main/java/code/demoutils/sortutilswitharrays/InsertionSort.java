package code.demoutils.sortutilswitharrays;

import java.util.Arrays;

/**
 * Created by anayonkar on 1/2/16.
 */
public class InsertionSort {
    private static final int[] arr = {3, 7, 4, 9, 5, 2, 6, 1};
    public static int[] insertionSort(int[] input) {
        for(int index = 1 ; index < input.length ; ++index) {
            int value = input[index];
            for(int i = 0 ; i < index ; ++i) {
                if(input[i] > value) {
                    System.arraycopy(input, i, input, i + 1, index - i);
                    input[i] = value;
                    break;
                }
            }
        }
        return input;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(insertionSort(arr)));
    }
}
