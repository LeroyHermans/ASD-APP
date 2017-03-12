package it.sijmen.han.trees;

import it.sijmen.han.lists.SLinkedList;
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