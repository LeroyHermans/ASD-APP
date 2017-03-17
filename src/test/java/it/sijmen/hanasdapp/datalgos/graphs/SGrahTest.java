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

package it.sijmen.hanasdapp.datalgos.graphs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sijmen on 5-3-2017.
 */
public class SGrahTest {

    /**
     *     -> C
     *   A      -> D
     *     -> B
     */
    SGrah abcdGrah;

    /**
     *     -> C
     *   A      -> D  <- E
     *     -> B
     *  /\
     *  |
     *  F
     */
    SGrah abcdefGrah;

    /**
     *    a -> b
     *
     *    q
     */
    SGrah abqGrah;

    @Before
    public void setUp() throws Exception {
        abcdGrah = new SGrah();
        abcdGrah.addEdge("A", "B", 3);
        abcdGrah.addEdge("B", "D", 6);
        abcdGrah.addEdge("A", "C", 6);
        abcdGrah.addEdge("C", "D", 2);

        abcdefGrah = new SGrah();
        abcdefGrah.addEdge("A", "B", 3);
        abcdefGrah.addEdge("B", "D", 6);
        abcdefGrah.addEdge("A", "C", 6);
        abcdefGrah.addEdge("C", "D", 2);
        abcdefGrah.addEdge("F", "A", 5);
        abcdefGrah.addEdge("E", "D", 4);

        abqGrah = new SGrah();
        abqGrah.addEdge("A", "B", 10);
        abqGrah.getAndAddNode("Q");
    }

    @Test
    public void testIsConnectedStrong() throws Exception {
        assertTrue(abcdGrah.isConnected());
    }

    @Test
    public void testIsConnectedWeak() throws Exception {
        assertTrue(abcdefGrah.isConnected());
    }

    @Test
    public void testIsConnectedNot() throws Exception {
        assertFalse(abqGrah.isConnected());
    }
}