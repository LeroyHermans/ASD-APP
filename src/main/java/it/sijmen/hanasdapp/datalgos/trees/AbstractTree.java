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

import it.sijmen.hanasdapp.datalgos.trees.algos.EqualsAlgo;
import it.sijmen.hanasdapp.datalgos.trees.algos.SizeAlgo;
import it.sijmen.hanasdapp.datalgos.trees.algos.ToStringAlgo;
import it.sijmen.hanasdapp.datalgos.trees.algos.HeightAlgo;

/**
 * Created by Sijmen on 6-3-2017.
 */
public abstract class AbstractTree<T> {

    public T value;

    /**
     * Get the direct nodes in this tree.
     * DOES NOT GET ALL SUB-NODES!
     */
    public abstract AbstractTree<T>[] getNodes();

    public abstract T getValue();

    public abstract void setValue(T v);

    @Override
    public String toString() {
        ToStringAlgo<T> toString = new ToStringAlgo<>();
        return toString.apply(this);
    }

    public int getSize(){
        SizeAlgo<T> sizeAlgo = new SizeAlgo<>();
        return sizeAlgo.apply(this);
    }

    public int getHeight() {
        HeightAlgo<T> heightAlgo = new HeightAlgo<>();
        return heightAlgo.apply(this);
    }

    @Override
    public boolean equals(Object o) {
        if(!this.getClass().equals(o.getClass()))
            return false;

        EqualsAlgo<T> equalsAlgo = new EqualsAlgo<>(this);
        return equalsAlgo.apply((AbstractTree<T>) o);
    }
}
