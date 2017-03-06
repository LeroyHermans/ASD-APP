package it.sijmen.han.trees;

/**
 * Sijmens Super Binary Tree.
 * Value cannot be null
 *
 * Created by Sijmen on 6-3-2017.
 */
public class SBinaryTree<T> extends AbstractTree<T> {

    private T value;
    private SBinaryTree<T> left;
    private SBinaryTree<T> right;

    public SBinaryTree(T value) {
        if(value == null)
            throw new IllegalArgumentException("Value cannot be null");
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public T value() {
        return value;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }

    public SBinaryTree<T> left() {
        return left;
    }

    public SBinaryTree<T> left(T value) {
        this.left = new SBinaryTree<>(value);
        return left;
    }

    public boolean hasLeft(){
        return left() != null;
    }

    public SBinaryTree<T> right() {
        return this.right;
    }

    public SBinaryTree<T> right(T value) {
        this.right = new SBinaryTree<>(value);
        return this.right;
    }

    public boolean hasRight(){
        return right() != null;
    }

    @Override
    public AbstractTree<T>[] getNodes() {
        if(hasLeft()){
            if(hasRight())
                return new SBinaryTree[]{left, right};
            return new SBinaryTree[]{left};
        }
        if(hasRight())
            return new SBinaryTree[]{right};
        return new SBinaryTree[0];
    }

    @Override
    public T getValue() {
        return value;
    }

}
