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
import it.sijmen.hanasdapp.datalgos.graphs.PathElement;
import it.sijmen.hanasdapp.datalgos.graphs.SGrah;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Sijmen on 5-3-2017.
 */
public abstract class PathFinder {

    protected Map<Node, PathNodeInfo> pathInformation = null;
    protected Node startNode = null;
    protected SGrah grah;

    public PathFinder(SGrah grah) {
        this.grah = grah;
        pathInformation = new HashMap<>();
    }

    protected void findPath(Node start) {
        this.startNode = start;
        pathInformation.clear();
    }

    /**
     * returns an array with the path to the given destenation.
     * The first element is the start, the last element is the
     * given destination.
     */
    public PathElement[] getPath(Node dest) throws PathNotFoundException {
        if(startNode == null)
            throw new IllegalStateException("No findPath run yet");

        LinkedList<PathElement> elements = new LinkedList<>();
        elements.add(dest);

        Node curNode = dest;

        while(curNode != null && curNode != startNode){
            PathNodeInfo destInfo = getNodeInfo(curNode);

            if(destInfo.dist == -1)
                throw new PathNotFoundException();

            elements.addFirst(destInfo.edgeToPrev);
            elements.addFirst(destInfo.prev);

            curNode = destInfo.prev;
        }

        return elements.toArray(new PathElement[elements.size()]);
    }

    public String getPathString(Node dest) throws PathNotFoundException {
        PathElement[] path = getPath(dest);

        StringBuilder b = new StringBuilder();
        for (int i = 0; ; i++) {
            if(path[i] instanceof Edge)
                b.append(((Edge)path[i]).cost);
            else if(path[i] instanceof Node)
                b.append(((Node)path[i]).name);
            if (i+1 == path.length)
                return b.toString();
            b.append("->");
        }
    }

    protected PathNodeInfo getNodeInfo(Node curNode) {
        if(pathInformation.containsKey(curNode))
            return pathInformation.get(curNode);
        PathNodeInfo pathNodeInfo = new PathNodeInfo();
        pathInformation.put(curNode, pathNodeInfo);
        return pathNodeInfo;
    }


    class PathNodeInfo {

        /**
         * Cost
         */
        public double dist;

        /**
         * Previous node on shortest path
         */
        public Node prev;

        /**
         * The edge that is used to get to the prev node.
         */
        public Edge edgeToPrev;

        /**
         * Extra variable used in algorithm
         */
        public int scratch;

        /**
         * Extra variable used in algorithm
         */
        public boolean isProcessed;

        public PathNodeInfo() {
            reset();
        }

        public void reset() {
            dist = -1;
            prev = null;
            scratch = 0;
            isProcessed = false;
            edgeToPrev = null;
        }

        @Override
        public String toString() {
            return "PathNodeInfo{" +
                    "dist=" + dist +
                    ", prev=" + prev +
                    ", edgeToPrev=" + edgeToPrev +
                    ", scratch=" + scratch +
                    ", isProcessed=" + isProcessed +
                    '}';
        }
    }

    public class PathNotFoundException extends Exception {
    }
}
