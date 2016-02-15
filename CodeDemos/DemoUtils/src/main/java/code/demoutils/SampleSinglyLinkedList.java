package code.demoutils;

/**
 * Created by anayonkar on 9/2/16.
 */
public class SampleSinglyLinkedList<T> {
    private T node;
    private SampleSinglyLinkedList<T> next;

    public SampleSinglyLinkedList(T node, SampleSinglyLinkedList<T> next) {
        this(node);
        this.next = next;
    }

    public SampleSinglyLinkedList(T node) {
        this.node = node;
    }

    public T getNode() {
        return node;
    }

    public SampleSinglyLinkedList<T> getNext() {
        return next;
    }

    public void setNext(SampleSinglyLinkedList<T> next) {
        this.next = next;
    }

    public SampleSinglyLinkedList<T> add(SampleSinglyLinkedList<T> sampleSinglyLinkedList) {
        SampleSinglyLinkedList<T> temp = this;
        while(temp.next != null) temp = temp.next;
        temp.next = sampleSinglyLinkedList;
        return this;
    }

    public boolean hasLoop() {
        SampleSinglyLinkedList<T> slow = this;
        SampleSinglyLinkedList<T> fast = this.next;
        while(true) {
            if(fast == null || fast.next == null) {
                return false;
            } else if(fast == slow || fast.next == slow) {
                return true;
            } else {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
    }

    @Override
    public String toString() {
        if(this.next == null) {
            return nodeToString(this.node)/* + "->null"*/;
        } else {
            return nodeToString(this.node) + "->" + this.next.toString();
        }
    }

    private String nodeToString(T node) {
        return node == null ? "null" : node.toString();
    }
}
