package code.demoutils;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by anayonkar on 9/2/16.
 */
public class LinkedListDemoTest {
    @Test
    public void testLinkedList() {
        SampleLinkedList<Integer> linkedList = new SampleLinkedList<>(Integer.valueOf(1),
                new SampleLinkedList<>(Integer.valueOf(2),
                        new SampleLinkedList<>(Integer.valueOf(3),
                                new SampleLinkedList<>(Integer.valueOf(4),
                                        new SampleLinkedList<>(Integer.valueOf(5),
                                                null)))));
        final String result = "1->2->3->4->5";
        Assert.assertEquals("message", result, linkedList.toString());
    }
    @Test
    public void testLinkedListReverse() {
        SampleLinkedList<Integer> linkedList = new SampleLinkedList<>(Integer.valueOf(1),
                new SampleLinkedList<>(Integer.valueOf(2),
                        new SampleLinkedList<>(Integer.valueOf(3),
                                new SampleLinkedList<>(Integer.valueOf(4),
                                        new SampleLinkedList<>(Integer.valueOf(5),
                                                null)))));
        final String result = "5->4->3->2->1";
        Assert.assertEquals("message", result, LinkedListDemo.reverse(linkedList).toString());
    }
}
