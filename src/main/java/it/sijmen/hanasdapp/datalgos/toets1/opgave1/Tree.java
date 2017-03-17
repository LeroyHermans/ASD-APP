/*
 * MIT License
 *
 * Copyright (c) 2017 Sijmen Huizenga
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package it.sijmen.hanasdapp.datalgos.toets1.opgave1;

import it.sijmen.hanasdapp.datalgos.lists.SArrayList;
import it.sijmen.hanasdapp.datalgos.trees.AbstractTree;
import it.sijmen.hanasdapp.datalgos.trees.algos.CompareFinderAlgo;

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
