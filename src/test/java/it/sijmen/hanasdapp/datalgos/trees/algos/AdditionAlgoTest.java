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

import it.sijmen.hanasdapp.datalgos.trees.STree;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sijmen on 6-3-2017.
 */
public class AdditionAlgoTest {

    @Test
    public void testAddNumber() throws Exception {
        STree<Integer> tree = new STree<>();
        tree.addNode(10).addNode(10).addNode(10);
        tree.addNode(10).addNode(10);
        tree.addNode(10);

        AdditionAlgo algo = new AdditionAlgo(1);
        algo.apply(tree);

        assertValuesEqual(tree, 11);

    }

    private void assertValuesEqual(STree<Integer> tree, int expected) {
        if(tree.getValue() != null)
            assertEquals(expected, (int)tree.getValue());
        if(tree.hasNodes())
            for(STree<Integer> n : tree.getNodes())
                assertValuesEqual(n, expected);
    }
}