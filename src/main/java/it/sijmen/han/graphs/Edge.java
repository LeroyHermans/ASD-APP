package it.sijmen.han.graphs;

/**
 * Represents an edge in the graph.
 *
 * Created by Sijmen on 5-3-2017.
 */
class Edge implements Comparable<Edge> {
    /**
     * Second node in Edge
     */
    public Node dest;

    /**
     * Edge cost
     */
    public double cost;

    public Edge(Node d, double c) {
        dest = d;
        cost = c;
    }

    @Override
    public int compareTo(Edge other) {
        return Double.compare(cost, other.cost);
    }
}