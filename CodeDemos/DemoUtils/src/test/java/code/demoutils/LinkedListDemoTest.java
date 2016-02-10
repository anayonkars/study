package code.demoutils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by anayonkar on 9/2/16.
 */
public class LinkedListDemoTest {
    private SampleLinkedList<Integer> linkedList;

    @Before
    public void init() {
        linkedList = new SampleLinkedList<>(Integer.valueOf(1),
                new SampleLinkedList<>(Integer.valueOf(2),
                        new SampleLinkedList<>(Integer.valueOf(3),
                                new SampleLinkedList<>(Integer.valueOf(4),
                                        new SampleLinkedList<>(Integer.valueOf(5),
                                                null)))));
    }
    @Test
    public void testLinkedList() {
        final String result = "1->2->3->4->5";
        Assert.assertEquals("message", result, linkedList.toString());
    }
    @Test
    public void testLinkedListReverse() {
        final String result = "5->4->3->2->1";
        Assert.assertEquals("message", result, LinkedListDemo.reverse(linkedList).toString());
    }
}
