package it.sijmen.han.trees;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sijmen on 5-3-2017.
 */
public class STreeTest {

    STree<String> supertree;

    @Before
    public void setUp() throws Exception {
        supertree = new STree<>("X");

        STree<String> a = supertree.addNode("A");
        a.addNode("B");
        STree<String> c = a.addNode("C");
        c.addNode("D");
        c.addNode("E");
        c.addNode("F");

        STree<String> d = supertree.addNode("GGGGGGGG");
        d.addNode("H");
        STree<String> f = d.addNode("IIIIIIII");
        f.addNode("JJJJJJJ");
        f.addNode("K");
        f.addNode("L");
//        STree<String> m = f.addNode("M");
//        m.addNode("N");
//        m.addNode("O");
//        m.addNode("P");
//        m.addNode("Q");
    }

    @Test
    public void testToString() throws Exception {
        System.out.println(supertree.toString());
    }
}