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

package it.sijmen.hanasdapp.datalgos.trees;

import it.sijmen.hanasdapp.datalgos.trees.algos.CompareFinderAlgo;

/**
 * Sijmens Super Custom Binary Search Tree
 *
 * A SBinarySearchTree must always have at least 1 item.
 *
 * Created by Sijmen on 7-3-2017.
 */
public class SBinarySearchTree<T extends Comparable<T>> extends AbstractTree<T> {

    private T value;

    private SBinarySearchTree<T> left, right;

    public SBinarySearchTree() {
        
    }

    public void add(T newValue) {
        if(newValue == null)
            throw new IllegalArgumentException("Key cannot be null");
        if(this.getValue() == null) {
            this.setValue(newValue);
            return;
        }
        int compareto = newValue.compareTo(getValue());
        if(compareto == 0)
            throw new IllegalArgumentException("Key already in tree");
        else if(compareto < 0){  // newkey < this.value
            if(!hasLeft())
                this.setLeft(createNewNode());
            this.getLeft().add(newValue);
        } else {
            if(!hasRight())
                this.setRight(createNewNode());
            this.getRight().add(newValue);
        }
    }

    public void add(T... newValue) {
        for(T t : newValue)
            add(t);
    }

    public T find(T key) {
        SBinarySearchTree<T> subTree = findSubTree(key);
        if(subTree == null)
            return null;
        return subTree.getValue();
    }

    private SBinarySearchTree<T> findSubTree(T key){
        if(getValue() == null)
            return null;
        if(key == null)
            throw new IllegalArgumentException("Key cannot be null");
        int compareto = key.compareTo(getValue());
        if(compareto == 0)
            return this;
        else if(compareto > 0) { //newkey > value
            if (!hasRight())
                return null;
            return getRight().findSubTree(key);
        }else {
            if(!hasLeft())
                return null;
            return getLeft().findSubTree(key);
        }
    }

    public SBinarySearchTree<T> findLowest() {
        CompareFinderAlgo<SBinarySearchTree<T>, T> algo
                = new CompareFinderAlgo<>(
                (o1, o2) -> {
                    if(o1 == null && o2 == null)
                        return 0;
                    if(o2 == null) return 1;
                    if(o1 == null) return -1;
                    return o2.getValue().compareTo(o1.getValue());
                }
        );
        return algo.apply(this);
    }

    public SBinarySearchTree<T> findHighest() {
        CompareFinderAlgo<SBinarySearchTree<T>, T> algo
                = new CompareFinderAlgo<>(
                (o1, o2) -> {
                    if(o1 == null && o2 == null)
                        return 0;
                    if(o1 == null) return 1;
                    if(o2 == null) return -1;
                    return o1.getValue().compareTo(o2.getValue());
                }
        );
        return algo.apply(this);
    }

    public void remove(T key){
        if(getValue() == null)
            throw new IllegalArgumentException("Key not found");
        if(key == null)
            throw new IllegalArgumentException("Key cannot be null");
        int compareto = key.compareTo(getValue());
        if(compareto == 0) {
            remove();
        } else if(compareto > 0) { //newkey > value
            if (!hasRight())
                throw new IllegalArgumentException("Key not found");
            getRight().remove(key);
        }else {
            if(!hasLeft())
                throw new IllegalArgumentException("Key not found");
            getLeft().remove(key);
        }
    }


    protected void remove(){
        if(!hasAChild()){
            //no children means bottom of tree so we can delete the value
            this.setValue(null);
        }else if(hasBothChilds()){
            SBinarySearchTree<T> lowest = getRight().findLowest();
            this.setValue(lowest.getValue());
            lowest.setValue(null);
        }else{
            if(hasRight()){
                setValue(getRight().getValue());
                setRight(null);
            }else{
                setValue(getLeft().getValue());
                setLeft(null);
            }
        }
    }

    @Override
    public SBinarySearchTree<T>[] getNodes() {
        if(hasLeft()){
            if(hasRight())
                return new SBinarySearchTree[]{getLeft(), getRight()};
            return new SBinarySearchTree[]{getLeft()};
        }
        if(hasRight())
            return new SBinarySearchTree[]{getRight()};
        return new SBinarySearchTree[0];
    }

    public SBinarySearchTree<T> createNewNode() {
        return new SBinarySearchTree<>();
    }

    @Override
    public T getValue() {
        return value;
    }

    public boolean hasRight(){
        return this.getRight() != null && this.getRight().value != null;
    }

    public boolean hasLeft(){
        return this.getLeft() != null && this.getLeft().value != null;
    }

    public boolean hasBothChilds() {
        return hasLeft() && hasRight();
    }

    public boolean hasAChild(){
        return hasLeft() || hasRight();
    }

    public boolean hasValue(){
        return this.value != null;
    }

    @Override
    public void setValue(T v) {
        this.value = v;
    }

    public SBinarySearchTree<T> getLeft() {
        return left;
    }

    protected void setLeft(SBinarySearchTree<T> left) {
        this.left = left;
    }

    public SBinarySearchTree<T> getRight() {
        return right;
    }

    protected void setRight(SBinarySearchTree<T> right) {
        this.right = right;
    }
}
