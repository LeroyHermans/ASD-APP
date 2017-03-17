package it.sijmen.hanasdapp.datalgos.trees;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sijmen on 5-3-2017.
 */
public class STreeTest {

    @Test
    public void testEverything() throws Exception {
        STree<String> supertree = new STree<>();

        assertTrue(supertree.isEmpty());
        supertree.setValue("X");
        assertFalse(supertree.isEmpty());

        assertFalse(supertree.hasNodes());
        STree<String> a = supertree.addNode("A");
        assertFalse(supertree.isEmpty());
        assertTrue(supertree.hasNodes());
        assertEquals(a, supertree.getNodes()[0]);

        supertree.removeNode(a);

        assertTrue(!supertree.hasNodes());
        assertFalse(supertree.hasNodes());
        assertEquals(0, supertree.getNodes().length);

        a = supertree.addNode("a2");
        assertEquals("a2", a.getValue());
        a.setValue("a");
        assertEquals("a", a.getValue());
    }
}