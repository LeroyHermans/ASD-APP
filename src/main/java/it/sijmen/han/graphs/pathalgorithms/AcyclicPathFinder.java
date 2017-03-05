package it.sijmen.han.graphs.pathalgorithms;

import it.sijmen.han.graphs.Edge;
import it.sijmen.han.graphs.Node;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Sijmen on 5-3-2017.
 */
public class AcyclicPathFinder {

//    /**
//     * Single-source negative-weighted acyclic-graph shortest-path algorithm.
//     */
//    public void acyclic(String startName) {
//        Node start = getNode(startName);
//
//        clearAll();
//        Queue<Node> q = new LinkedList<>();
//        start.dist = 0;
//
//        // Compute the indegrees
//        Collection<Node> nodeSet = getNodes();
//        for (Node v : nodeSet)
//            for (Edge e : v.adj)
//                e.dest.scratch++;
//
//        // Enqueue vertices of indegree zero
//        for (Node v : nodeSet)
//            if (v.scratch == 0)
//                q.add(v);
//
//        int iterations;
//        for (iterations = 0; !q.isEmpty(); iterations++) {
//            Node v = q.remove();
//
//            for (Edge e : v.adj) {
//                Node w = e.dest;
//                double cvw = e.cost;
//
//                if (--w.scratch == 0)
//                    q.add(w);
//
//                if (v.dist == -1)
//                    continue;
//
//                if (w.dist > v.dist + cvw) {
//                    w.dist = v.dist + cvw;
//                    w.prev = v;
//                }
//            }
//        }
//
//        if (iterations != getNodeCount())
//            throw new IllegalStateException("Graph has a cycle!");
//    }

}
