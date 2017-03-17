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
    public SBinaryTree<T>[] getNodes() {
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
