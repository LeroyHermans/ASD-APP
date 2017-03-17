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
import it.sijmen.hanasdapp.datalgos.trees.TreeTestSeeder;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sijmen on 10-3-2017.
 */
public class EqualsAlgoTest extends TreeTestSeeder {

    @Test
    public void testTreeEquals() throws Exception {
        assertTrue(sTree.equals(sTree));
        assertTrue(binaryTree.equals(binaryTree));
        assertFalse(binaryTree.equals(sTree));

        STree<String> tree1 = new STree<>("10");
        tree1.addNode("11");
        tree1.addNode("12");
        tree1.addNode("13");

        STree<String> tree2 = new STree<>("10");
        tree2.addNode("11");
        tree2.addNode("13");
        tree2.addNode("12");

        assertFalse(tree1.equals(tree2));

        STree<String> tree3 = new STree<>("10");
        tree3.addNode("11");
        tree3.addNode("12");
        tree3.addNode("13").addNode("14");

        assertFalse(tree1.equals(tree3));
    }
}