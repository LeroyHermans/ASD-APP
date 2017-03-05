package it.sijmen.han.graphs.pathalgorithms;

import it.sijmen.han.graphs.Edge;
import it.sijmen.han.graphs.Node;

import java.util.LinkedList;

/**
 * Created by Sijmen on 5-3-2017.
 */
public class NegativePathFinder {

//    /**
//     * Single-source negative-weighted shortest-path algorithm.
//     */
//    public void negative(String startName) {
//        clearAll();
//
//        Node start = getNode(startName);
//
//        LinkedList<Node> q = new LinkedList<>();
//        q.add(start);
//        start.dist = 0;
//        start.scratch++;
//
//        while (!q.isEmpty()) {
//            Node v = q.removeFirst();
//            if (v.scratch++ > 2 * getNodeCount())
//                throw new IllegalStateException("Negative cycle detected");
//
//            for (Edge e : v.adj) {
//                Node w = e.dest;
//                double cvw = e.cost;
//
//                if (w.dist > v.dist + cvw) {
//                    w.dist = v.dist + cvw;
//                    w.prev = v;
//                    // Enqueue only if not already on the queue
//                    if (w.scratch++ % 2 == 0)
//                        q.add(w);
//                    else
//                        w.scratch--;  // undo the enqueue increment
//                }
//            }
//        }
//    }

}
