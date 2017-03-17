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

package it.sijmen.hanasdapp.datalgos.trees.algos;

import it.sijmen.hanasdapp.datalgos.trees.TreeTestSeeder;
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