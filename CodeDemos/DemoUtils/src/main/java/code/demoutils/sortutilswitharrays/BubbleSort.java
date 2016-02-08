package code.demoutils.sortutilswitharrays;

import java.util.Arrays;

/**
 * Created by anayonkar on 8/2/16.
 */
public class BubbleSort {
    private static final int[] arr = {3, 7, 4, 9, 5, 2, 6, 1};
    public static int[] bubbleSort(int[] input) {
        boolean numbersSwitched = false;
        do {
            numbersSwitched = false;
            for (int i = 0 ; i < input.length -1 ; i++) {
                if(input[i + 1] < input[i]) {
                    swap(input, i + 1, i);
                    numbersSwitched = true;
                }
            }
        } while (numbersSwitched);
        return input;
    }
    private static void swap(int[] input, int index1, int index2) {
        int temp = input[index1];
        input[index1] = input[index2];
        input[index2] = temp;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }
}
