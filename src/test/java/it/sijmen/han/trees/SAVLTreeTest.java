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

        SAVLTree<Integer> untilNow = SAVLTreeBuilder.build(root -> {
            root.value(12);
            root.left(left -> {
                left.value(8);
                left.right(10);
                left.left(leftleft -> {
                    leftleft.value(4);
                    leftleft.left(2);
                    leftleft.right(6);
                });
            });
            root.right(right -> {
                right.value(16);
                right.left(14);
            });
        });
        assertEquals(untilNow, tree);

        tree.add(1);

        SAVLTree<Integer> afterSwich = SAVLTreeBuilder.build(root -> {
            root.value(12);
            root.left(left -> {
                left.value(4);
                left.left(2)
                        .left(1);
                left.right(lr -> {
                    lr.value(8);
                    lr.left(6);
                    lr.right(10);
                });
            });
            root.right(16)
                    .right(14);
        });

        assertEquals(afterSwich, tree);

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