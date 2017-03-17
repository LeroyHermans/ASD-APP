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

package it.sijmen.hanasdapp.datalgos.graphs.pathalgorithms;

import it.sijmen.hanasdapp.datalgos.graphs.SGrah;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sijmen on 12-3-2017.
 */
public class DijkstraPathFinderTest {

    @Test
    public void testFindPath() throws Exception {
        SGrah abcdGrah = new SGrah();

        abcdGrah.addEdge("A", "B", 3);
        abcdGrah.addEdge("B", "D", 6);

        abcdGrah.addEdge("A", "C", 6);
        abcdGrah.addEdge("C", "D", 2);

        DijkstraPathFinder finder = new DijkstraPathFinder(abcdGrah);
        finder.findPath(abcdGrah.getNode("A"));

        assertEquals("A->6.0->C->2.0->D", finder.getPathString(abcdGrah.getNode("D")));
    }

    @Test
    public void testFindPathMinimal() throws Exception {
        SGrah abcdGrah = new SGrah();

        abcdGrah.addEdge("A", "B", 3);
        abcdGrah.addEdge("B", "C", 6);
        abcdGrah.addEdge("A", "C", 2);

        DijkstraPathFinder finder = new DijkstraPathFinder(abcdGrah);
        finder.findPath(abcdGrah.getNode("A"));

        assertEquals("A->2.0->C", finder.getPathString(abcdGrah.getNode("C")));
    }

    @Test
    public void testFindPathHuge() throws Exception {
        SGrah abcdGrah = new SGrah();

        abcdGrah.addEdge("A", "B", 1);
        abcdGrah.addEdge("B", "C", 2);
        abcdGrah.addEdge("C", "D", 3);
        abcdGrah.addEdge("D", "E", 4);
        abcdGrah.addEdge("E", "F", 5);
        abcdGrah.addEdge("F", "G", 6);
        abcdGrah.addEdge("A", "D", 5);
        abcdGrah.addEdge("D", "F", 6);
        abcdGrah.addEdge("F", "D", 7);
        abcdGrah.addEdge("B", "A", 9);
        abcdGrah.addEdge("C", "F", 9);

        DijkstraPathFinder finder = new DijkstraPathFinder(abcdGrah);
        finder.findPath(abcdGrah.getNode("A"));

        assertEquals("A->5.0->D->6.0->F", finder.getPathString(abcdGrah.getNode("F")));
    }

    @Test(expected = PathFinder.PathNotFoundException.class)
    public void testFindPathNotFound() throws Exception {
        SGrah abcdGrah = new SGrah();

        abcdGrah.addEdge("A", "B", 3);
        abcdGrah.addEdge("B", "C", 6);
        abcdGrah.addEdge("D", "E", 2);

        DijkstraPathFinder finder = new DijkstraPathFinder(abcdGrah);
        finder.findPath(abcdGrah.getNode("A"));

        finder.getPathString(abcdGrah.getNode("E"));
    }
}