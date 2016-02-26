package code.demoutils;

/**
 * Created by ANAYONKS on 15/02/2016.
 */
public class TreeDemo {
    public static void main(String[] args) {
        SampleBinaryTree<Integer> leftTree = new SampleBinaryTree<Integer>(50);
        /*leftTree.insertNode(25);
        leftTree.insertNode(75);*/
        leftTree.setLeft(new SampleBinaryTree<Integer>(25));
        leftTree.setRight(new SampleBinaryTree<Integer>(75));
        System.out.println(leftTree);
        SampleBinaryTree<Integer> rightTree = new SampleBinaryTree<Integer>(50);
        /*rightTree.insertNode(25);
        rightTree.insertNode(75);*/
        rightTree.setLeft(new SampleBinaryTree<Integer>(75));
        rightTree.setRight(new SampleBinaryTree<Integer>(25));
        System.out.println(rightTree);
        SampleBinaryTree<Integer> tree = new SampleBinaryTree<Integer>(50, leftTree, rightTree);
        System.out.println(tree);
        System.out.println(leftTree.isMirrorImage());
        System.out.println(rightTree.isMirrorImage());
        System.out.println(tree.isMirrorImage());
        System.out.println(tree.getHeight());
    }
}
