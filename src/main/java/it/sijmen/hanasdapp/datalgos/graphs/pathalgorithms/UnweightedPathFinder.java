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
