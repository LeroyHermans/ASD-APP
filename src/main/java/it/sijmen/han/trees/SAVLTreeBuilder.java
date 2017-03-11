package it.sijmen.han.trees;

/**
 * Created by Sijmen on 10-3-2017.
 */
public class SAVLTreeBuilder<T extends Comparable<T>> {

    private T value;
    private SAVLTreeBuilder<T> leftBuilder;
    private SAVLTreeBuilder<T> rightBuilder;

    public static <T extends Comparable<T>> SAVLTree<T> build(TreePartBuilderRunner<T> builderRunner){
        SAVLTreeBuilder<T> builder = new SAVLTreeBuilder<>(builderRunner);
        return builder.makeTree();
    }

    public SAVLTree<T> makeTree() {
        if(this.value == null)
            return null;
        SAVLTree<T> tree = new SAVLTree<>();
        tree.setValue(this.value);
        tree.runWithoutBalance(t -> {
            if (leftBuilder != null)
                t.setLeft(leftBuilder.makeTree());
            if (rightBuilder != null)
                t.setRight(rightBuilder.makeTree());
        });
        return tree;
    }

    public SAVLTreeBuilder(TreePartBuilderRunner<T> builder){
        builder.build(this);
    }

    @FunctionalInterface
    public interface TreePartBuilderRunner<T extends Comparable<T>> {
        void build(SAVLTreeBuilder<T> builder);
    }

    public SAVLTreeBuilder<T> value(T value){
        this.value = value;
        return this;
    }

    public SAVLTreeBuilder<T> leftright(T left, T right){
        this.left(left);
        this.right(right);
        return this;
    }

    public SAVLTreeBuilder<T> left(T left){
        if(leftBuilder == null)
            leftBuilder = new SAVLTreeBuilder<>(b -> b.value(left));
        else
            leftBuilder.value(left);
        return leftBuilder;
    }

    public SAVLTreeBuilder<T> left(T leftValue, T leftLeft, T leftRight){
        if(leftBuilder == null)
            leftBuilder = new SAVLTreeBuilder<>(b -> b.value(leftValue).leftright(leftLeft, leftRight));
        else
            leftBuilder.value(leftValue).leftright(leftValue, leftRight);
        return this;
    }

    public SAVLTreeBuilder<T> right(T right){
        if(rightBuilder == null)
            rightBuilder = new SAVLTreeBuilder<>(b -> b.value(right));
        else
            rightBuilder.value(right);
        return rightBuilder;
    }

    public SAVLTreeBuilder<T> left(TreePartBuilderRunner<T> left){
        if(leftBuilder == null)
            leftBuilder = new SAVLTreeBuilder<>(left);
        else
            left.build(leftBuilder);
        return leftBuilder;
    }

    public SAVLTreeBuilder<T> right(TreePartBuilderRunner<T> right){
        if(rightBuilder == null)
            rightBuilder = new SAVLTreeBuilder<>(right);
        else
            right.build(rightBuilder);
        return this;
    }

    public SAVLTreeBuilder<T> right(T rightValue, T rightLeft, T rightRight){
        if(rightBuilder == null)
            rightBuilder = new SAVLTreeBuilder<>(b -> b.value(rightValue).leftright(rightLeft,rightRight));
        else
            rightBuilder.value(rightValue).left(rightLeft).right(rightRight);
        return this;
    }

}
