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

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sijmen on 6-3-2017.
 */
public class SBinaryTreeTest {

    @Test
    public void testEverything() throws Exception {
        SBinaryTree<String> supertree = new SBinaryTree<>("X");

        //test initialing values
        assertFalse(supertree.hasRight());
        assertFalse(supertree.hasLeft());
        assertEquals("X", supertree.getValue());

        //test left
        SBinaryTree<String> l = supertree.left("L");
        assertEquals(l, supertree.left());
        assertEquals(l.value(), "L");

        //test right
        SBinaryTree<String> r = supertree.right("R");
        assertEquals(r, supertree.right());
        assertEquals(r.value(), "R");
    }

}