package code.demoutils.sortutils;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by anayonkar on 1/2/16.
 */
public class MergeSortTest {
    @Test
    public void mergeSortTest() {
        Assert.assertArrayEquals(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                MergeSort.mergeSort(new int[] {3, 4, 2, 1, 7, 5, 8, 9, 0, 6}));
    }
}
