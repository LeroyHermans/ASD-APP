package it.sijmen.han.trees.algos;

import it.sijmen.han.trees.TreeTestSeeder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sijmen on 6-3-2017.
 */
public class ToStringAlgoTest extends TreeTestSeeder{

    @Test
    public void testTreeToStringSTree() throws Exception {
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
                        "[3] = JJJJJJJ\r\n", sTree.toString());
    }

    @Test
    public void testTreeToStringSBinaryTree() throws Exception {
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