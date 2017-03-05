package it.sijmen.han.graphs.pathalgorithms;

import it.sijmen.han.graphs.Edge;
import it.sijmen.han.graphs.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Sijmen on 5-3-2017.
 */
public class UnweightedPathFinder {

    /**
     * Single-source unweighted shortest-path algorithm.
     */
    public void unweighted(String startName) {
        clearAll();

        Node start = getNode(startName);

        Queue<Node> q = new LinkedList<>();
        q.add(start);
        start.dist = 0;

        while (!q.isEmpty()) {
            Node v = q.remove();

            for (Edge e : v.adj) {
                Node w = e.dest;

                if (w.dist == -1) {
                    w.dist = v.dist + 1;
                    w.prev = v;
                    q.add(w);
                }
            }
        }
    }

}
