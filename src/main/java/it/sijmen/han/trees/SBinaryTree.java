package it.sijmen.han.trees;

/**
 * Sijmens Super Binary Tree.
 * Value cannot be null
 *
 * Created by Sijmen on 6-3-2017.
 */
public class SBinaryTree<T> {

    private T value;
    private SBinaryTree left;
    private SBinaryTree right;

    private SBinaryTree(T value) {
        if(value == null)
            throw new IllegalArgumentException("Value cannot be null");
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public T value() {
        return value;
    }

    public SBinaryTree value(T value) {
        this.value = value;
        return this;
    }

    public SBinaryTree left() {
        return left;
    }

    public SBinaryTree left(T value) {
        this.left = new SBinaryTree<>(value);
        return left;
    }

    public boolean hasLeft(){
        return left() != null;
    }

    public SBinaryTree right() {
        return this.right;
    }

    public SBinaryTree right(T value) {
        this.right = new SBinaryTree<>(value);
        return this.right;
    }

    public boolean hasRight(){
        return right() != null;
    }

}
