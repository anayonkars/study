package code.demoutils;

/**
 * Created by anayonkar on 9/2/16.
 */
public class SampleLinkedList<T> {
    private T node;
    private SampleLinkedList<T> next;

    public SampleLinkedList(T node, SampleLinkedList<T> next) {
        this.node = node;
        this.next = next;
    }

    public T getNode() {
        return node;
    }

    public SampleLinkedList<T> getNext() {
        return next;
    }

    public void setNext(SampleLinkedList<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        if(this.next == null) {
            return nodeToString(this.node);
        } else {
            return nodeToString(this.node) + "->" + this.next.toString();
        }
    }

    private String nodeToString(T node) {
        return node == null ? "null" : node.toString();
    }
}
