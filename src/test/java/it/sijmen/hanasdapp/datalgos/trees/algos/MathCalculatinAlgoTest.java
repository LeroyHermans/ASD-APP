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

import it.sijmen.hanasdapp.datalgos.trees.SBinaryTree;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sijmen on 7-3-2017.
 */
public class MathCalculatinAlgoTest {

    MathCalculatinAlgo algo = new MathCalculatinAlgo();

    @Test
    public void testApplySingleLayer() throws Exception {
        SBinaryTree<String> tree = new SBinaryTree<>("+");

        tree.left("10");
        tree.right("10");

        assertEquals((Integer)20, algo.apply(tree));
    }

    @Test
    public void testApplyTwoLayers() throws Exception {
        SBinaryTree<String> tree = new SBinaryTree<>("*");

        tree.left("10");
        SBinaryTree<String> right = tree.right("+");
        right.left("5");
        right.right("5");

        assertEquals((Integer) 100, algo.apply(tree));
    }

    @Test
    public void testAppllySumAdd(){
        assertEquals(10, algo.calculateSom("+", 5, 5));
    }

    @Test
    public void testAppllySumSubtract(){
        assertEquals(0, algo.calculateSom("-", 5, 5));
    }

    @Test
    public void testAppllySumMultiply(){
        assertEquals(25, algo.calculateSom("*", 5, 5));
    }

    @Test
    public void testAppllySumDevide(){
        assertEquals(2, algo.calculateSom("/", 10, 5));
    }
}