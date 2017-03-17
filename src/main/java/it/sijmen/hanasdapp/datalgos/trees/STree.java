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
