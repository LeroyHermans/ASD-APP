package it.sijmen.han.vertex;

import java.util.*;

/**
 * Created by Sijmen on 22-2-2017.
 */
public class Grah{

    public static final double INFINITY = Double.MAX_VALUE;

    protected Map<String, Node> nodeMap = new HashMap<>();

    /**
     * If vertexName is not present, add it to nodeMap.
     * In either case, return the Vertex.
     */
    private Node getAndAddNode(String nodeName) {
        Node v = nodeMap.get(nodeName);
        if (v == null) {
            v = new Node(nodeName);
            nodeMap.put(nodeName, v);
        }
        return v;
    }

    /**
     * get the node with the specific name
     */
    private Node getNode(String nodeName) {
        Node n = nodeMap.get(nodeName);
        if(n == null)
            throw new NoSuchElementException("Start node not found");
        return n;
    }

    private int getNodeCount(){
        return nodeMap.size();
    }

    private Collection<Node> getNodes(){
        return nodeMap.values();
    }

    /**
     * Add a new edge to the graph.
     */
    public void addEdge(String sourceName, String destName, double cost) {
        Node v = getAndAddNode(sourceName);
        Node w = getAndAddNode(destName);
        v.adj.add(new Edge(w, cost));
    }

    /**
     * Driver routine to handle unreachables and print total cost.
     * It calls recursive routine to print shortest path to
     * destNode after a shortest path algorithm has run.
     */
    public void printPath(String destName) {
        Node w = getNode(destName);
        if (w.dist == INFINITY)
            System.out.println(destName + " is unreachable");
        else {
            System.out.print("(Cost is: " + w.dist + ") ");
            printPath(w);
            System.out.println();
        }
    }

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

                if (w.dist == INFINITY) {
                    w.dist = v.dist + 1;
                    w.prev = v;
                    q.add(w);
                }
            }
        }
    }

    /**
     * Single-source weighted shortest-path algorithm.
     */
    public void dijkstra(String startName) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        Node start = this.getNode(startName);

        clearAll();
        pq.add(new Edge(start, 0));
        start.dist = 0;

        int nodesSeen = 0;
        while (!pq.isEmpty() && nodesSeen < getNodeCount()) {
            Edge vrec = pq.remove();
            Node v = vrec.dest;
            if (v.scratch != 0)  // already processed v
                continue;

            v.scratch = 1;
            nodesSeen++;

            for (Edge e : v.adj) {
                Node w = e.dest;
                double cvw = e.cost;

                if (cvw < 0)
                    throw new IllegalStateException("Graph has negative edges");

                if (w.dist > v.dist + cvw) {
                    w.dist = v.dist + cvw;
                    w.prev = v;
                    pq.add(new Edge(w, w.dist));
                }
            }
        }
    }

    /**
     * Single-source negative-weighted shortest-path algorithm.
     */
    public void negative(String startName) {
        clearAll();

        Node start = getNode(startName);

        LinkedList<Node> q = new LinkedList<>();
        q.add(start);
        start.dist = 0;
        start.scratch++;

        while (!q.isEmpty()) {
            Node v = q.removeFirst();
            if (v.scratch++ > 2 * getNodeCount())
                throw new IllegalStateException("Negative cycle detected");

            for (Edge e : v.adj) {
                Node w = e.dest;
                double cvw = e.cost;

                if (w.dist > v.dist + cvw) {
                    w.dist = v.dist + cvw;
                    w.prev = v;
                    // Enqueue only if not already on the queue
                    if (w.scratch++ % 2 == 0)
                        q.add(w);
                    else
                        w.scratch--;  // undo the enqueue increment
                }
            }
        }
    }

    /**
     * Single-source negative-weighted acyclic-graph shortest-path algorithm.
     */
    public void acyclic(String startName) {
        Node start = getNode(startName);

        clearAll();
        Queue<Node> q = new LinkedList<>();
        start.dist = 0;

        // Compute the indegrees
        Collection<Node> nodeSet = getNodes();
        for (Node v : nodeSet)
            for (Edge e : v.adj)
                e.dest.scratch++;

        // Enqueue vertices of indegree zero
        for (Node v : nodeSet)
            if (v.scratch == 0)
                q.add(v);

        int iterations;
        for (iterations = 0; !q.isEmpty(); iterations++) {
            Node v = q.remove();

            for (Edge e : v.adj) {
                Node w = e.dest;
                double cvw = e.cost;

                if (--w.scratch == 0)
                    q.add(w);

                if (v.dist == INFINITY)
                    continue;

                if (w.dist > v.dist + cvw) {
                    w.dist = v.dist + cvw;
                    w.prev = v;
                }
            }
        }

        if (iterations != getNodeCount())
            throw new IllegalStateException("Graph has a cycle!");
    }

    /**
     * Recursive routine to print shortest path to dest
     * after running shortest path algorithm. The path
     * is known to exist.
     */
    private void printPath(Node dest) {
        if (dest.prev != null) {
            printPath(dest.prev);
            System.out.print(" to ");
        }
        System.out.print(dest.name);
    }

    /**
     * Initializes the node output info prior to running
     * any shortest path algorithm.
     */
    private void clearAll() {
        for (Node v : getNodes())
            v.reset();
    }


    /**
     * Represents a node in the graph.
     */
    class Node {
        /**
         * Node name
         */
        public String name;
        /**
         * Adjacent vertices
         */
        public List<Edge> adj;
        /**
         * Cost
         */
        public double dist;
        /**
         * Previous node on shortest path
         */
        public Node prev;

        /**
         * Extra variable used in algorithm
         */
        public int scratch;

        public Node(String nm) {
            name = nm;
            adj = new LinkedList<>();
            reset();
        }

        public void reset() {
            dist = INFINITY;
            prev = null;
            scratch = 0;
        }
    }

    /**
     * Represents an edge in the graph.
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


}
