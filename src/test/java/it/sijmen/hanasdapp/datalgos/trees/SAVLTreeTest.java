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
        assertTrue(unablanced1234Tree.balanceTree());
        assertTrue(unablanced123Tree.balanceTree());
        assertFalse(unablanced12Tree.balanceTree());
        assertFalse(unablanced1Tree.balanceTree());
        assertFalse(emptyTree.balanceTree());
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
                        4, 7);
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


    @Test
    public void testBalanceRL() throws Exception {
        SAVLTree<Integer> tree = SAVLTreeBuilder.build(root -> {
            root.value(30)
                    .left(25);
            root.right(r -> {
                r.value(50);
                r.left(40);
                r.right(60);
            });
        });

        tree.add(35);

        SAVLTree<Integer> after = SAVLTreeBuilder.build(root ->
                        root.value(40)
                                .left(30, 25, 35)
                                .right(50).right(60)
        );

        assertEquals(after, tree);
    }

    @Test
    public void testAllRotations() throws Exception {
        SAVLTree<Integer> tree = new SAVLTree<>();
        tree.add( 1, 7, 4, 9, 5, 6);

        SAVLTree<Integer> expected = SAVLTreeBuilder.build(root ->
            root.value(5)
                    .right(7, 6, 9)
                    .left(4).left(1)
        );

        assertEquals(expected, tree);
    }

    @Test
    public void testMoreThings() throws Exception {
        SAVLTree<Integer> tree = new SAVLTree<>();
        tree.add(20, 4, 15);

        SAVLTree<Integer> expected = SAVLTreeBuilder.build(root -> {
            root.value(15);
            root.left(4);
            root.right(20);
        });

        assertEquals(expected, tree);
    }

    @Test
    public void testDelete() throws Exception {
        /*
testdata from http://stackoverflow.com/a/13843966/2328729
  2          2            4
 / \          \          / \
1   4    =>    4    =>  2   5
   / \        / \        \
  3   5      3   5        3

         */

        SAVLTree<Integer> start = SAVLTreeBuilder.build(root -> {
            root.value(2);
            root.left(1);
            root.right(4, 3, 5);
        });

        start.remove(1);

        SAVLTree<Integer> expected = SAVLTreeBuilder.build(root -> {
            root.value(4);
            root.left(2).left(3);
            root.right(5);
        });

        assertEquals(expected, start);
    }

    @Test
    public void testDelete3Rotates() throws Exception {
        /*
        testdata from http://stackoverflow.com/a/13843966/2328729
    ___5___              ___5___                 ___5___                   ____8____
   /       \            /       \               /       \                 /         \
  2         8          2         8             3         8              _5_          A
 / \       / \          \       / \           / \       / \            /   \        / \
1   3     7   A     =>   3     7   A      => 2   4     7   A     =>   3     7      9   B
     \   /   / \          \   /   / \                 /   / \        / \   /            \
      4 6   9   B          4 6   9   B               6   9   B      2   4 6              C
                 \                    \                       \
                  C                    C                       C
         */
        SAVLTree<Integer> start = SAVLTreeBuilder.build(root -> {
            root.value(5);
            root.left(l -> {
                l.value(2);
                l.left(1);
                l.right(3).right(4);
            });
            root.right(r -> {
                r.value(8);
                r.left(7).left(6);
                r.right(rr -> {
                    rr.value(10);
                    rr.left(9);
                    rr.right(11).right(12);
                });
            });
        });

        start.remove(1);

        SAVLTree<Integer> expected = SAVLTreeBuilder.build(root -> {
            root.value(8);
            root.left(l ->{
                l.value(5);
                l.left(3, 2, 4);
                l.right(7).left(6);
            });
            root.right(r -> {
                r.value(10);
                r.left(9);
                r.right(11).right(12);
            });
        });

        assertEquals(expected, start);
    }
}