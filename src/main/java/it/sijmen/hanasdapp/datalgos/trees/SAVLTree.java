package it.sijmen.hanasdapp.datalgos.trees;

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
    public void add(T newValue) {
        super.add(newValue);
        if (enableAutobalance.get())
            balanceTree();
    }

    @Override
    public void remove(T key) {
        super.remove(key);
        if (enableAutobalance.get())
            balanceTree();
    }

    public boolean balanceTree() {
        int lHeight = getHeight(getLeft());
        int rHeight = getHeight(getRight());

        if(lHeight - rHeight >= 2){ //unbalanced, left is bigger
            if(getHeight(getLeft().getRight()) >
                    getHeight(getLeft().getLeft()))
                balanceLR();
            else
                balanceLL();
            return true;
        } else if(rHeight - lHeight >= 2) { //unbalanced, right is bigger
            if(getHeight(getRight().getLeft()) >
                    getHeight(getRight().getRight()))
                balanceRL();
            else
                balanceRR();
            return true;
        }
        return false;
    }

    private int getHeight(SAVLTree<T> n) {
        if(n == null)
            return 0;
        return n.getHeight();
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
        SAVLTree<T> r = getRight();

        SAVLTree<T> newRight = createNewNode();
        newRight.setValue(r.getLeft().getValue());
        newRight.setLeft(r.getLeft().getLeft());
        newRight.setRight(r);
        newRight.getRight().setLeft(
                r.getLeft().getRight());

        setRight(newRight);

        balanceRR();
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
