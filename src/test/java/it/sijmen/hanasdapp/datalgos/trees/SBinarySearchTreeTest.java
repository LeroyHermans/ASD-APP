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
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sijmen on 7-3-2017.
 */
public class SBinarySearchTreeTest {

    SBinarySearchTree<Integer> tree;

    @Before
    public void setUp() throws Exception {
        tree = new SBinarySearchTree<>();
    }

    @Test
    public void testAddLeft(){
        tree.add(10);
        tree.add(9);
        assertTrue(tree.hasLeft());
        assertFalse(tree.hasRight());
    }

    @Test
    public void testHasChildren(){
        assertFalse(tree.hasBothChilds());
        assertFalse(tree.hasLeft());
        assertFalse(tree.hasRight());
        tree.add(10);
        assertTrue(tree.hasValue());
        tree.add(9);
        assertTrue(tree.hasAChild());
        assertTrue(tree.hasLeft());
        tree.add(11);
        assertTrue(tree.hasBothChilds());
        assertTrue(tree.hasRight());
    }

    @Test
    public void testAddRight(){
        tree.add(10);
        tree.add(11);
        assertTrue(tree.hasRight());
        assertFalse(tree.hasLeft());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddEquals(){
        tree.add(10);
        tree.add(10);
    }

    @Test
    public void testFind(){
        tree.add(10);
        tree.add(9);
        tree.add(12);
        tree.add(14);
        tree.add(13);
        assertNull(tree.find(8));
        assertEquals(9,  (int)tree.find(9));
        assertEquals(10, (int)tree.find(10));
        assertEquals(12, (int)tree.find(12));
        assertEquals(14, (int)tree.find(14));
        assertEquals(13, (int)tree.find(13));
    }

    @Test
    public void testFindLowest(){
        tree.add(10);
        tree.add(9);
        tree.add(8);
        tree.add(7);
        assertEquals(7, (int)tree.findLowest().getValue());
        assertEquals(10, (int)tree.findHighest().getValue());
    }

    @Test
    public void testFindHighest(){
        tree.add(10);
        tree.add(9);
        tree.add(8);
        tree.add(7);
        assertEquals(10, (int) tree.findHighest().getValue());
    }

    @Test
    public void testRemoveCenter(){
        tree.add(4);
        tree.add(2);
        tree.add(6);

        tree.remove(4);
        assertEquals(6, (int)tree.getValue());
        assertEquals(2, (int)tree.getLeft().getValue());
        assertNull(tree.getRight().getValue());
    }

    @Test
    public void testRemoveLeft(){
        tree.add(4);  //center
        tree.add(2);  //left
        tree.add(6);  //right

        tree.remove(2);
        assertEquals(4, (int)tree.getValue());
        assertEquals(6, (int)tree.getRight().getValue());
        assertNull(tree.getLeft().getValue());
    }

    @Test
    public void testRemoveRight(){
        tree.add(4);  //center
        tree.add(2);  //left
        tree.add(6);  //right

        tree.remove(6);
        assertEquals(4, (int)tree.getValue());
        assertEquals(2, (int)tree.getLeft().getValue());
        assertNull(tree.getRight().getValue());
    }


}