package it.sijmen.han.toets1.opgave1;

import it.sijmen.han.lists.SArrayList;
import it.sijmen.han.trees.AbstractTree;
import it.sijmen.han.trees.algos.CompareFinderAlgo;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sijmen on 5-3-2017.
 */
public class Tree<T extends Comparable<T>> extends AbstractTree<T> {

    protected T value = null;

    SArrayList<Tree<T>> nodes = null;

    public Tree(T value){
        this.value = value;
    }
    public Tree(){

    }

    /**
     * Adds a leaf to the tree. Returns the leaf.
     */
    public Tree<T> addNode(T leafValvue){
        if(this.nodes == null)
            this.nodes = new SArrayList<>();
        Tree<T> leaf = new Tree<>(leafValvue);
        this.nodes.add(leaf);
        return leaf;
    }

    /**
     * Removes a node given a tree node
     */
    public Tree<T> remove(Tree<T> node){
        return this.nodes.getAndRemove(node);
    }

    /**
     * Removes all nodes with this value
     */
    public void remove(T valueToDelete){
        if(valueToDelete == null)
            throw new IllegalArgumentException("cannot be null");
        if(valueToDelete.equals(this.value)){
            this.setValue(null);
            this.nodes = null;
            return;
        }
        if(this.nodes == null)
            return;
        for(Tree<T> n : this.getNodes()){
            if(n == null)
                continue;
            if(valueToDelete.equals(n.getValue()))
                this.remove(n);
            else
                n.remove(valueToDelete);
        }
    }

    public void removeNodesGreaterOrEqualTo(T x){
        if(x == null)
            throw new IllegalArgumentException("cannot be null");
        if(this.nodes == null)
            return;
        for(Tree<T> n : this.getNodes()){
            if(n == null)
                continue;
            if(x.compareTo(n.getValue()) <= 0)
                this.remove(n);
            else
                n.removeNodesGreaterOrEqualTo(x);
        }
    }

    public boolean isEmpty(){
        return !this.hasNodes() && this.value == null;
    }

    public boolean hasNodes(){
        return this.nodes != null && this.nodes.size() > 0;
    }

    public T getValue() {
        return value;
    }

    public void removeMaximum(){
        T max = getMax();
        if(max == null)
            throw new IllegalArgumentException("no max fouund");
        remove(max);
    }

    public T getMax(){
        CompareFinderAlgo<Tree<T>, T> biggest = new CompareFinderAlgo<>(
                (o1, o2) -> o1.getValue().compareTo(o2.getValue())
        );
        return biggest.apply(this).getValue();
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }

    public Tree<T>[] getNodes() {
        if(nodes == null)
            return new Tree[0];
        return (Tree<T>[]) nodes.toArray(new Tree[nodes.length()]);
    }

    public void setNodes(SArrayList<Tree<T>> nodes) {
        this.nodes = nodes;
    }
}
