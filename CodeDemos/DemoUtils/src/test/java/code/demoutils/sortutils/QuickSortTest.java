package code.demoutils.sortutils;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by anayonkar on 1/2/16.
 */
public class QuickSortTest {
    @Test
    public void quickSortTest() {
        Assert.assertArrayEquals(new int[] {1, 2, 3, 4, 5, 5, 7, 8, 9},
                QuickSort.quickSort(new int[] {3, 7, 8, 5, 2, 1, 9, 5, 4}));
    }
}
