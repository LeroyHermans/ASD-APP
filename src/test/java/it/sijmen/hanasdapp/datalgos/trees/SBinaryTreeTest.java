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