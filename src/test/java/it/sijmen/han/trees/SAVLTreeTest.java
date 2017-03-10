package it.sijmen.han.trees;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sijmen on 8-3-2017.
 */
public class SAVLTreeTest {

    SAVLTree<Integer> unablanced1234Tree, unablanced123Tree,
            unablanced12Tree, unablanced1Tree, emptyTree;

    @Before
    public void setUp() throws Exception {
        unablanced1234Tree = new SAVLTree<>();
        unablanced1234Tree.runWithoutBalance((tree) -> {
            tree.add(1);
            tree.add(2);
            tree.add(3);
            tree.add(4);
        });

        unablanced123Tree = new SAVLTree<>();
        unablanced123Tree.runWithoutBalance((tree) -> {
            tree.add(1);
            tree.add(2);
            tree.add(3);
        });

        unablanced12Tree = new SAVLTree<>();
        unablanced12Tree.runWithoutBalance((tree) -> {
            tree.add(1);
            tree.add(2);
        });

        unablanced1Tree = new SAVLTree<>();
        unablanced1Tree.runWithoutBalance((tree) -> {
            tree.add(1);
        });

        emptyTree = new SAVLTree<>();
    }

    @Test
    public void testShouldBalance() throws Exception {
        assertFalse(unablanced1234Tree.isTreeBalanced());
        assertFalse(unablanced123Tree.isTreeBalanced());
        assertTrue(unablanced12Tree.isTreeBalanced());
        assertTrue(unablanced1Tree.isTreeBalanced());
        assertTrue(emptyTree.isTreeBalanced());
    }

    @Test
    public void testBalanceLL() throws Exception {
        SAVLTree<Integer> tree = new SAVLTree<>();
        tree.add(12);
        tree.add(8);
        tree.add(16);
        tree.add(4);
        tree.add(10);
        tree.add(14);
        tree.add(2);
        tree.add(6);

        assertEquals(
                "        12\r\n" +
                        "    /       \\\r\n" +
                        "     8      16\r\n" +
                        "    /  \\    |\r\n" +
                        "    4  10  14\r\n" +
                        "    /\\\r\n" +
                        "  2  6\r\n", tree.toString());
        tree.add(1);

        assertEquals(
                "        12\r\n" +
                        "    /       \\\r\n" +
                        "     4      16\r\n" +
                        "    /  \\    |\r\n" +
                        "   2    8  14\r\n" +
                        "   |    /\\\r\n" +
                        "  1   6  10\r\n", tree.toString());

    }

    @Test
    public void testBalanceRR() throws Exception {
        SAVLTree<Integer> tree = new SAVLTree<>();

        tree.add(1);
        tree.add(0);
        tree.add(3);
        tree.add(-1);
        tree.add(2);
        tree.add(5);
        tree.add(4);
        tree.add(7);

        assertEquals("      1\r\n" +
                "    /   \\\r\n" +
                "   0     3\r\n" +
                "   |    / \\\r\n" +
                "  -1  2    5\r\n" +
                "           /\\\r\n" +
                "         4  7\r\n", tree.toString());

        tree.add(6);

        assertEquals("      1\r\n" +
                "    /    \\\r\n" +
                "   0      5\r\n" +
                "   |    /   \\\r\n" +
                "  -1    3    7\r\n" +
                "        /\\   |\r\n" +
                "      2  4  6\r\n", tree.toString());
    }
}