package it.sijmen.han.graphs.pathalgorithms;

import it.sijmen.han.graphs.Edge;
import it.sijmen.han.graphs.Node;
import it.sijmen.han.graphs.SGrah;

import java.util.PriorityQueue;

/**
 * Created by Sijmen on 5-3-2017.
 */
public class DijkstraPathFinder extends PathFinder {

    public DijkstraPathFinder(SGrah grah) {
        super(grah);
    }

    /**
     * Single-source weighted shortest-path algorithm.
     *
     *   1. add an empty edge with destenation to A with length 0 to the todolist
     *   2. go through the todolist until the list is empty or we have visited all nodes.
     *      For every edge in the todolist do the following:
     *      1. Get the destenation node
     *      2. Loop through all adjason edges
     *          1. Get the next Node
     *          2. if
     *            A: the dist field of the node is empty, we know we have not yet visited
     *               this node. This means the sortest path to this node is (at this moment)
     *               the current path.
     *               or
     *            B: the dist field of the node is bigger than the sum of the
     *                current node distance and edge distance. This means the sorter
     *                path to this node is the current path.
     *             In both cases, add it to the list.
     *          3. Else ignore it.
     *
     */
    @Override
    protected void findPath(Node start) {
        super.findPath(start);
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        int nodesSeen = 0;
        Node curNode = start;
        do {
            PathNodeInfo curNodeInfo = getNodeInfo(curNode);
            if (curNodeInfo.isProcessed)
                continue;

            curNodeInfo.isProcessed = true;
            nodesSeen++;

            for (Edge adjPath : curNode.adj) {
                Node adjDest = adjPath.dest;
                PathNodeInfo adjNodeDst = getNodeInfo(adjDest);

                if (adjPath.cost < 0)
                    throw new IllegalStateException("Graph has negative edges");

                //if we did not yet visit the adjDest,
                //or the new (current) route is shorter than the already registered route
                if (adjNodeDst.dist == -1 ||
                        curNodeInfo.dist +  adjPath.cost < adjNodeDst.dist) {
                    //than we set the route
                    adjNodeDst.dist = curNodeInfo.dist +  adjPath.cost;
                    adjNodeDst.prev = curNode;
                    adjNodeDst.edgeToPrev = adjPath;
                    //and make sure we visit the next node
                    pq.add(new Edge(adjDest, adjNodeDst.dist));
                }
            }
        }while (!pq.isEmpty() &&
                (curNode = pq.remove().dest) != null
                && nodesSeen < grah.getNodeCount());
    }
}