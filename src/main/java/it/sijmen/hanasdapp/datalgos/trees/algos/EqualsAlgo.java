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

package it.sijmen.hanasdapp.datalgos.trees.algos;

import it.sijmen.hanasdapp.datalgos.trees.AbstractTree;

/**
 * Created by Sijmen on 10-3-2017.
 */
public class EqualsAlgo<T> implements TreeAlgorithm<T, Boolean> {

    AbstractTree<T> baseTree;

    public EqualsAlgo(AbstractTree<T> baseTree) {
        this.baseTree = baseTree;
    }

    @Override
    public Boolean apply(AbstractTree<T> otherTree) {
        return treeEquals(baseTree, otherTree);
    }

    protected boolean treeEquals(AbstractTree<T> a, AbstractTree<T> b){
        if(!valuesEqual(a, b))
            return false;
        AbstractTree<T>[] nodesA = a.getNodes();
        AbstractTree<T>[] nodesB = b.getNodes();
        if(nodesA.length != nodesB.length)
            return false;
        for(int i = 0; i < nodesA.length; i++)
            if(!treeEquals(nodesA[i], nodesB[i]))
                return false;
        return true;
    }

    private boolean valuesEqual(AbstractTree<T> a, AbstractTree<T> b) {
        if(a.getValue() == b.getValue())
            return true;
        if(a.getValue() == null || b.getValue() == null)
            return false;
        return a.getValue().equals(b.getValue());
    }
}
