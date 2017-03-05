package it.sijmen.han.graphs.pathalgorithms;

import it.sijmen.han.graphs.Edge;
import it.sijmen.han.graphs.Node;
import it.sijmen.han.graphs.PathElement;
import it.sijmen.han.graphs.SGrah;
import it.sijmen.han.maps.SSeperateChainingHashMap;

import java.util.ArrayList;
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
