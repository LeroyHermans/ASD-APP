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
        unablanced1234Tree = SAVLTreeBuilder.build(root -> root.value(1).right(2).right(3).right(4));
        unablanced123Tree = SAVLTreeBuilder.build(root -> root.value(1).right(2).right(3));
        unablanced12Tree = SAVLTreeBuilder.build(root -> root.value(1).right(2));
        unablanced1Tree = SAVLTreeBuilder.build(root -> root.value(1));

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
        SAVLTree<Integer> tree = SAVLTreeBuilder.build(root -> {
            root.value(12);
            root.left(left -> {
                left.value(8);
                left.right(10);
                left.left(4,
                        2,6);
            });
            root.right(right -> {
                right.value(16);
                right.left(14);
            });
        });

        tree.add(1);

        SAVLTree<Integer> afterSwich = SAVLTreeBuilder.build(root -> {
            root.value(12);
            root.left(left -> {
                left.value(4);
                left.left(2)
                        .left(1);
                left.right(8,
                        6, 10);
            });
            root.right(16)
                    .right(14);
        });

        assertEquals(afterSwich, tree);

    }

    @Test
    public void testBalanceRR() throws Exception {
        SAVLTree<Integer> tree = SAVLTreeBuilder.build(root -> {
            root.value(1);
            root.left(0).left(-1);
            root.right(r -> {
                r.value(3);
                r.left(2);
                r.right(5,
                        4,7);
            });
        });

        tree.add(6);

        SAVLTree<Integer> afterSwich = SAVLTreeBuilder.build(root -> {
            root.value(1);
            root.left(0).left(-1);
            root.right(r -> {
                r.value(5);
                r.left(3,
                        2, 4);
                r.right(7).left(6);
            });
        });

        assertEquals(afterSwich, tree);
    }

    @Test
    public void testBalanceLR() throws Exception {
        SAVLTree<Integer> tree = SAVLTreeBuilder.build(root -> {
            root.value(50)
                    .right(60);
            root.left(l -> {
                l.value(30);
                l.left(20);
                l.right(40);
            });
        });

        tree.add(45);

        SAVLTree<Integer> after = SAVLTreeBuilder.build(root ->
            root.value(40)
                    .right(50, 45, 60)
                    .left(30).right(20)
        );

        assertEquals(after, tree);

    }
}