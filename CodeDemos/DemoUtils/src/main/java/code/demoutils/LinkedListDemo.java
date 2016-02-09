package code.demoutils;

import java.util.LinkedList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by ANAYONKS on 09/02/2016.
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        SampleLinkedList<Integer> linkedList = new SampleLinkedList<>(Integer.valueOf(1),
                new SampleLinkedList<>(Integer.valueOf(2),
                        new SampleLinkedList<>(Integer.valueOf(3),
                                new SampleLinkedList<>(Integer.valueOf(4),
                                        new SampleLinkedList<>(Integer.valueOf(5),
                                                null)))));
        System.out.println(linkedList);
        System.out.println(reverse(linkedList));
    }
    public static <T> SampleLinkedList<T> reverse(final SampleLinkedList<T> input) {
        if(input == null) {
            throw new NullPointerException("Null input");
        }
        if(input.getNext() == null) {
            return input;
        }
        final SampleLinkedList<T> nextList = input.getNext();
        input.setNext(null);
        final SampleLinkedList<T> result = reverse(nextList);
        nextList.setNext(input);
        return result;
    }
}
