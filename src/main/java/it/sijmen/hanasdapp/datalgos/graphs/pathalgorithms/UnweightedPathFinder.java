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

import it.sijmen.hanasdapp.datalgos.graphs.Edge;
import it.sijmen.hanasdapp.datalgos.graphs.Node;
import it.sijmen.hanasdapp.datalgos.graphs.SGrah;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Sijmen on 5-3-2017.
 */
public class UnweightedPathFinder extends PathFinder{

    public UnweightedPathFinder(SGrah grah) {
        super(grah);
    }

    /**
     * Single-source unweighted shortest-path algorithm.
     */
    @Override
    protected void findPath(Node start) {
        super.findPath(start);

        Queue<Node> q = new LinkedList<>();
        Node curNode = start;
        do{
            PathNodeInfo curNodeInfo = getNodeInfo(curNode);
            for (Edge e : curNode.adj) {
                Node adjNode = e.dest;
                PathNodeInfo adjNodeInfo = getNodeInfo(adjNode);

                if (adjNodeInfo.dist == -1) {
                    adjNodeInfo.dist = curNodeInfo.dist + 1;
                    adjNodeInfo.edgeToPrev = e;
                    adjNodeInfo.prev = curNode;
                    q.add(adjNode);
                }
            }
        }while (!q.isEmpty() && (curNode = q.remove()) != null);
    }
}
