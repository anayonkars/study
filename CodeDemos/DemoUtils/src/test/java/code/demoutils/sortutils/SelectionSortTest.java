package code.demoutils.sortutils;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by anayonkar on 1/2/16.
 */
public class SelectionSortTest {
    @Test
    public void selectionSortTest() {
        Assert.assertArrayEquals(new int[] {11, 12, 22, 25, 64},
                SelectionSort.selectionSort(new int[] {64, 25, 12, 22, 11}));
    }
}
