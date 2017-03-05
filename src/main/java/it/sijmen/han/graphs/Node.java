package it.sijmen.han.graphs;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents a node in the graph.
 *
 * Created by Sijmen on 5-3-2017.
 */
public class Node extends PathElement {

    /**
     * Node name
     */
    public String name;

    /**
     * Adjacent vertices
     */
    public List<Edge> adj;

    public Node(String nm) {
        name = nm;
        adj = new LinkedList<>();
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", adj=" + adj +
                '}';
    }
}