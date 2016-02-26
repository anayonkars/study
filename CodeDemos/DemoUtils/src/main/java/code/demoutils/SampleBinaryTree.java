package code.demoutils;

import java.util.Comparator;

/**
 * Created by ANAYONKS on 15/02/2016.
 */
public class SampleBinaryTree<T extends Comparable> {
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

    public void insertNode(T node) {
        insertNode(this, node);
    }

    private SampleBinaryTree<T> insertNode(SampleBinaryTree<T> root, T node) {
        if(root == null) {
            root = new SampleBinaryTree<T>(node);
        } else {
            if(node.compareTo(root.node) < 0) {
                root.left = insertNode(root.left, node);
            } else {
                root.right = insertNode(root.right, node);
            }
        }
        return root;
    }

    public boolean isMirrorImage() {
        return isMirrorImage(this.left, this.right);
    }

    private boolean isMirrorImage(SampleBinaryTree<T> left, SampleBinaryTree<T> right) {
        /*if(left == null || right == null) return left == null && right == null;
        return left.node.equals(right.node)
                && isMirrorImage(left.left, right.right)
                && isMirrorImage(left.right, right.left);*/
        return (left == null || right == null) ? left == null && right == null :
                left.getNode().equals(right.getNode())
                && isMirrorImage(left.getLeft(), right.getRight())
                && isMirrorImage(left.getRight(), right.getLeft());
    }

    @Override
    public String toString() {
        return inOrderTraversal(new StringBuilder());
    }

    private String inOrderTraversal(StringBuilder result) {
        if(this.left != null) left.inOrderTraversal(result);
        result.append(" " + node + " ");
        if(this.right != null) right.inOrderTraversal(result);
        return result.toString();
    }

    public int getHeight() {
        return getHeight(this);
    }

    private int getHeight(SampleBinaryTree<T> root) {
        return root == null ? 0 :
                1 + Math.max(getHeight(root.getLeft()), getHeight(root.getRight()));
    }

    public T getNode() {
        return node;
    }

    public void setNode(T node) {
        this.node = node;
    }

    public SampleBinaryTree<T> getLeft() {
        return left;
    }

    public void setLeft(SampleBinaryTree<T> left) {
        this.left = left;
    }

    public SampleBinaryTree<T> getRight() {
        return right;
    }

    public void setRight(SampleBinaryTree<T> right) {
        this.right = right;
    }
}
