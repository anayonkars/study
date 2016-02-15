package code.demoutils;

/**
 * Created by ANAYONKS on 09/02/2016.
 */
public class LinkedListDemo {
    public static void main(String[] args) {
       /* SampleSinglyLinkedList<Integer> linkedList = new SampleSinglyLinkedList<>(Integer.valueOf(1),
                new SampleSinglyLinkedList<>(Integer.valueOf(2),
                        new SampleSinglyLinkedList<>(Integer.valueOf(3),
                                new SampleSinglyLinkedList<>(Integer.valueOf(4),
                                        new SampleSinglyLinkedList<>(Integer.valueOf(5),
                                                null)))));*/
        SampleSinglyLinkedList<Integer> linkedList = new SampleSinglyLinkedList<>(Integer.valueOf(1));
        linkedList.add(new SampleSinglyLinkedList<>(Integer.valueOf(2), null));
        SampleSinglyLinkedList<Integer> templist = linkedList.add(new SampleSinglyLinkedList<>(Integer.valueOf(3), null));
        linkedList.add(new SampleSinglyLinkedList<>(Integer.valueOf(4), null));
        linkedList.add(new SampleSinglyLinkedList<>(Integer.valueOf(5), templist));
        /*System.out.println(linkedList);
        linkedList = reverse(linkedList);
        System.out.println(linkedList);*/
        System.out.println(linkedList.hasLoop());
    }
    public static <T> SampleSinglyLinkedList<T> reverse(final SampleSinglyLinkedList<T> input) {
        if(input == null) {
            throw new NullPointerException("Null input");
        }
        if(input.getNext() == null) {
            return input;
        }
        final SampleSinglyLinkedList<T> nextList = input.getNext();
        input.setNext(null);
        final SampleSinglyLinkedList<T> result = reverse(nextList);
        nextList.setNext(input);
        //result.setNext(input);
        return result;
    }
}
