package it.sijmen.hanasdapp.datalgos.trees;

import it.sijmen.hanasdapp.datalgos.lists.SArrayList;

/**
 * Created by Sijmen on 5-3-2017.
 */
public class STree<T> extends AbstractTree<T> {

    protected T value = null;

    SArrayList<STree<T>> nodes = null;

    public STree(T value){
        this.value = value;
    }
    public STree(){

    }

    /**
     * Adds a leaf to the tree. Returns the leaf.
     */
    public STree<T> addNode(T leafValvue){
        if(this.nodes == null)
            this.nodes = new SArrayList<>();
        STree<T> leaf = new STree<>(leafValvue);
        this.nodes.add(leaf);
        return leaf;
    }

    /**
     * Removes a node
     */
    public STree<T> removeNode(STree<T> node){
        return this.nodes.getAndRemove(node);
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

    @Override
    public void setValue(T value) {
        this.value = value;
    }

    public STree<T>[] getNodes() {
        if(nodes == null)
            return new STree[0];
        return (STree<T>[]) nodes.toArray(new STree[nodes.length()]);
    }

    public void setNodes(SArrayList<STree<T>> nodes) {
        this.nodes = nodes;
    }
}
