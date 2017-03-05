package it.sijmen.han.graphs;

import it.sijmen.han.maps.SSeperateChainingHashMap;

import java.util.*;

/**
 * Sijmens Super Grahp
 *
 * Weighted Directed Graph
 * 
 * Created by Sijmen on 22-2-2017.
 */
public class SGrah {

    protected Map<String, Node> nodes = new SSeperateChainingHashMap<>();

    /**
     * If vertexName is not present, add it to nodes.
     * In either case, return the Vertex.
     */
    public Node getAndAddNode(String nodeName) {
        Node node = nodes.get(nodeName);
        if (node == null) {
            node = new Node(nodeName);
            nodes.put(nodeName, node);
        }
        return node;
    }

    /**
     * Get a node with the specific name
     */
    public Node getNode(String nodeName) {
        Node node = nodes.get(nodeName);
        if(node == null)
            throw new NoSuchElementException("Start node not found");
        return node;
    }

    /**
     * The amount of nodes
     */
    public int getNodeCount(){
        return nodes.size();
    }

    private Collection<Node> getNodes(){
        return nodes.values();
    }

    /**
     * Add a new edge to the graph.
     */
    public void addEdge(String sourceName, String destName, double cost) {
        Node s = getAndAddNode(sourceName);
        Node d = getAndAddNode(destName);
        s.adj.add(new Edge(d, cost));
    }

    /**
     * Initializes the node output info prior to running
     * any shortest path algorithm.
     */
    private void clearAll() {
        for (Node v : getNodes())
            v.reset();
    }

}
