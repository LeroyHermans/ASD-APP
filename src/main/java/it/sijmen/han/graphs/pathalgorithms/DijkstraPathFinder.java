package it.sijmen.han.graphs.pathalgorithms;

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
    protected void findPath(PathNode start) {
        PriorityQueue<PathEdge> pq = new PriorityQueue<>();

        pq.add(new PathEdge(start, 0));
        start.dist = 0;

        int nodesSeen = 0;
        while (!pq.isEmpty() && nodesSeen < grah.getNodeCount()) {
            PathEdge curEdge = pq.remove();
            PathNode curNode = (PathNode) curEdge.dest;
            if (curNode.isProcessed)
                continue;

            curNode.isProcessed = true;
            nodesSeen++;

            for (PathEdge adjPath : curNode.adj()) {
                PathNode adjDest = (PathNode) adjPath.dest;

                if (adjPath.cost < 0)
                    throw new IllegalStateException("Graph has negative edges");

                //if we did not yet visit the adjDest,
                //or the new (current) route is shorter than the already registered route
                if (adjDest.dist == -1 ||
                        curNode.dist +  adjPath.cost < adjDest.dist) {
                    //than we set the route
                    adjDest.dist = curNode.dist +  adjPath.cost;
                    adjDest.prev = curNode;
                    //and make sure we visit the next node
                    pq.add(new PathEdge(adjDest, adjDest.dist));
                }
            }
        }
    }
}
