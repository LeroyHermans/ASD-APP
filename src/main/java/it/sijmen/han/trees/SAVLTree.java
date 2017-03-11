package it.sijmen.han.trees;

import it.sijmen.han.lists.SLinkedList;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Sijmen on 7-3-2017.
 */
public class SAVLTree<T extends Comparable<T>> extends SBinarySearchTree<T> {

    private AtomicBoolean enableAutobalance;

    public SAVLTree() {
        enableAutobalance = new AtomicBoolean(true);
    }

    protected SAVLTree(AtomicBoolean enableAutobalance) {
        this.enableAutobalance = enableAutobalance;
    }

    public void runWithoutBalance(TreeExecutor<T> r) {
        enableAutobalance.set(false);
        r.run(this);
        enableAutobalance.set(true);
    }

    @Override
    protected SLinkedList<Integer> addAndGetRoute(T newValue) {
        SLinkedList<Integer> location = super.addAndGetRoute(newValue);
        if (enableAutobalance.get())
            balanceTree(location);
        return location;
    }

    @Override
    public void remove() {
        super.remove();
        //todo
    }

    public void balanceTree(SLinkedList<Integer> location) {
        if (isTreeBalanced())
            return;

        System.out.println("Balancing from node " + this.getValue() + " original looks like: ");
        System.out.println(this);

        // the location of the new node relative to this node
        int lr1 = location.get(0);

        // the location of the new node relative to my child node
        int lr2 = location.get(1);

        if (lr1 == 1) {
            if (lr2 == 1)
                balanceRR();
            else
                balanceRL();
        } else {
            if (lr2 == 1)
                balanceLR();
            else
                balanceLL();
        }

        System.out.println("after: ");
        System.out.println(this);
    }

    /**
     * Balane a tree where a new overflowing value
     * has been added to the left side of the left subtree.
     */
    private void balanceLL() {
        T thisOldValue = this.getValue();

        this.setValue(getLeft().getValue());

        SAVLTree<T> newRightNode = createNewNode();
        newRightNode.setValue(thisOldValue);
        newRightNode.setRight(this.getRight());
        newRightNode.setLeft(this.getLeft().getRight());

        setRight(newRightNode);

        this.setLeft(getLeft().getLeft());
    }

    private void balanceRR() {
        T thisOldValue = this.getValue();

        this.setValue(getRight().getValue());

        SAVLTree<T> newLeftNode = createNewNode();
        newLeftNode.setValue(thisOldValue);
        newLeftNode.setLeft(this.getLeft());
        newLeftNode.setRight(this.getRight().getLeft());

        setLeft(newLeftNode);

        this.setRight(getRight().getRight());
    }

    private void balanceLR() {
        SAVLTree<T> l = getLeft();

        SAVLTree<T> newLeft = createNewNode();
        newLeft.setValue(l.getRight().getValue());
        newLeft.setRight(l.getRight().getRight());
        newLeft.setLeft(l);
        newLeft.getLeft().setRight(l.getRight().getLeft());

        setLeft(newLeft);

        balanceLL();
    }

    private void balanceRL() {

    }

    /**
     * Returns wether or not the tree is unbalanced.
     */
    boolean isTreeBalanced() {
        int leftHeight = 0, rightHeight = 0;
        if (hasLeft())
            leftHeight = getLeft().getHeight();
        if (hasRight())
            rightHeight = getRight().getHeight();

        return Math.abs(leftHeight - rightHeight) < 2;
    }

    @FunctionalInterface
    public interface TreeExecutor<T extends Comparable<T>> {
        void run(SAVLTree<T> tree);
    }

    @Override
    public SAVLTree<T> createNewNode() {
        return new SAVLTree<>(this.enableAutobalance);
    }

    @Override
    public SAVLTree<T> getLeft() {
        return (SAVLTree<T>) super.getLeft();
    }

    @Override
    public SAVLTree<T> getRight() {
        return (SAVLTree<T>) super.getRight();
    }

    protected void setLeft(SBinarySearchTree<T> left) {
        if (left != null && !(left instanceof SAVLTree))
            throw new IllegalArgumentException("left should be SAVLTree");
        super.setLeft(left);
    }

    protected void setRight(SBinarySearchTree<T> right) {
        if (right != null && !(right instanceof SAVLTree))
            throw new IllegalArgumentException("right should be SAVLTree");
        super.setRight(right);
    }
}
