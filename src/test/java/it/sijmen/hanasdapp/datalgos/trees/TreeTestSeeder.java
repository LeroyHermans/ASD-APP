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

import org.junit.Before;

/**
 * Created by Sijmen on 6-3-2017.
 */
public class TreeTestSeeder {

    protected STree<String> sTree;
    protected SBinaryTree<String> binaryTree;

    @Before
    public void setUp(){
        sTree = new STree<>("X");

        STree<String> a = sTree.addNode("A");
        a.addNode("B");
        STree<String> c = a.addNode("C");
        c.addNode("D");
        c.addNode("E");
        c.addNode("F");

        STree<String> d = sTree.addNode("GGGGGGGG");
        d.addNode("H");
        STree<String> f = d.addNode("IIIIIIII");
        f.addNode("JJJJJJJ");
        f.addNode("K");
        f.addNode("L");


        binaryTree = new SBinaryTree<>("X");
        SBinaryTree<String> ab = binaryTree.left("A");
        ab.left("B");
        SBinaryTree<String> cc = ab.right("C");
        cc.left("D");
        cc.right("E");
        binaryTree.right("GGGGGGGG");
    }

}
