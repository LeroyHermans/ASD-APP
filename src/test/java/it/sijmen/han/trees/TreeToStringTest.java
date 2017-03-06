package it.sijmen.han.trees;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sijmen on 6-3-2017.
 */
public class TreeToStringTest {

    @Test
    public void testTreeToStringSTree() throws Exception {
        STree<String> supertree = new STree<>("X");

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

        assertEquals(
                        "          X\r\n" +
                        "    /            \\\r\n" +
                        "     A          [1]\r\n" +
                        "    /  \\     /     \\\r\n" +
                        "  B     C  H      [2]\r\n" +
                        "       /| \\     / |  \\\r\n" +
                        "     D  E  F  [3]  K  L\r\n" +
                        "References:\r\n" +
                        "[1] = GGGGGGGG\r\n" +
                        "[2] = IIIIIIII\r\n" +
                        "[3] = JJJJJJJ\r\n", supertree.toString());
    }

    @Test
    public void testTreeToStringSBinaryTree() throws Exception {
        SBinaryTree<String> binaryTree = new SBinaryTree<>("X");
        SBinaryTree<String> a = binaryTree.left("A");
        a.left("B");
        SBinaryTree<String> c = a.right("C");
        c.left("D");
        c.right("E");
        binaryTree.right("GGGGGGGG");
        assertEquals("      X\r\n" +
                "    /    \\\r\n" +
                "     A  [1]\r\n" +
                "    / \\\r\n" +
                "  B    C\r\n" +
                "       /\\\r\n" +
                "     D  E\r\n" +
                "References:\r\n" +
                "[1] = GGGGGGGG\r\n", binaryTree.toString());
    }
}