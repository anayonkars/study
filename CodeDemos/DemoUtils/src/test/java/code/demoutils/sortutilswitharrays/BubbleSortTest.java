package code.demoutils.sortutilswitharrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by anayonkar on 8/2/16.
 */
public class BubbleSortTest {
    @Test
    public void testBubbleSort() {
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 9},
                BubbleSort.bubbleSort(new int[]{3, 7, 4, 9, 5, 2, 6, 1}));
    }
}
