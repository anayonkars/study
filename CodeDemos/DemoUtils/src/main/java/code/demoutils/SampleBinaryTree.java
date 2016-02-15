package code.demoutils;

/**
 * Created by ANAYONKS on 15/02/2016.
 */
public class SampleBinaryTree<T> {
    private T node;
    private SampleBinaryTree<T> left;
    private SampleBinaryTree<T> right;

    public SampleBinaryTree(T node, SampleBinaryTree<T> left, SampleBinaryTree<T> right) {
        this(node);
        this.left = left;
        this.right = right;
    }

    public SampleBinaryTree(T node) {
        this.node = node;
    }
}
