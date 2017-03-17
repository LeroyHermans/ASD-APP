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