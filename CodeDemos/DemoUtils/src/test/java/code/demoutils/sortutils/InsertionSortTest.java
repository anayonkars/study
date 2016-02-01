package code.demoutils.sortutils;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by anayonkar on 1/2/16.
 */
public class InsertionSortTest {
    @Test
    public void testInsertionSort() {
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 9},
                InsertionSort.insertionSort(new int[]{3, 7, 4, 9, 5, 2, 6, 1}));
    }
}
