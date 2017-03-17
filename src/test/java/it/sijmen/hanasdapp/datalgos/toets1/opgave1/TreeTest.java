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

import org.junit.Test;

/**
 * Created by Sijmen on 15-3-2017.
 */
public class TreeTest {

    protected Tree<Integer> makeOpgave1Tree(){
        Tree<Integer> tree = new Tree<>(17);
        Tree<Integer> leaf12 = tree.addNode(12);
        Tree<Integer> leaf33 = tree.addNode(33);
        leaf12.addNode(7);
        leaf12.addNode(24);
        leaf12.addNode(5);
        leaf33.addNode(15);
        leaf33.addNode(58);
        return tree;
    }

    @Test
    public void testOpgave1a() throws Exception {
        Tree<Integer> tree = makeOpgave1Tree();
        System.out.println(tree);
    }

    @Test
    public void testOpgave1b() throws Exception {
        Tree<Integer> tree = makeOpgave1Tree();
        tree.removeNodesGreaterOrEqualTo(15);
        System.out.println(tree);
    }

    @Test
    public void testOpageve1c() throws Exception {
        Tree<Integer> tree = makeOpgave1Tree();
        tree.removeMaximum();
        tree.removeMaximum();
        tree.removeMaximum();
        System.out.println(tree);
    }


}