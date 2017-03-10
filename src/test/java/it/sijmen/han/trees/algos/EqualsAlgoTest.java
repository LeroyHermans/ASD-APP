package it.sijmen.han.trees.algos;

import it.sijmen.han.trees.STree;
import it.sijmen.han.trees.TreeTestSeeder;
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