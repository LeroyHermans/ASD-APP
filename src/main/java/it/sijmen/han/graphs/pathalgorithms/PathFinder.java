package it.sijmen.han.graphs.pathalgorithms;

import it.sijmen.han.graphs.Edge;
import it.sijmen.han.graphs.Node;
import it.sijmen.han.graphs.SGrah;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sijmen on 5-3-2017.
 */
public abstract class PathFinder {

    protected SGrah grah;

    public PathFinder(SGrah grah) {
        this.grah = grah;
    }

    public void findPath(String startNode){
        Node node = grah.getNode(startNode);
        findPath(new PathNode(node));
    }

    protected abstract void findPath(PathNode startNode);

    /**
     * Driver routine to handle unreachables and print total cost.
     * It calls recursive routine to print shortest path to
     * destNode after a shortest path algorithm has run.
     */
    public void printPath(PathNode dest) {
        if (dest.dist == -1)
            System.out.println(dest.name + " is unreachable");
        else {
            System.out.print("(Cost is: " + dest.dist + ") ");
            printPath(dest);
            System.out.println();
        }
    }

    class PathNode extends Node {

        /**
         * Cost
         */
        public double dist;
        /**
         * Previous node on shortest path
         */
        public PathNode prev;

        /**
         * Extra variable used in algorithm
         */
        public int scratch;

        /**
         * Extra variable used in algorithm
         */
        public boolean isProcessed = false;

        public PathNode(String nm) {
            super(nm);
            reset();
        }

        /**
         * convert a normal Node into a PathNode
         */
        public PathNode(Node node){
            super(node.name);
            for(Edge ad : node.adj) {
                if (ad instanceof PathEdge)
                    this.adj.add(ad);
                else
                    this.adj.add(new PathEdge(ad));
            }
        }

        public void reset() {
            dist = -1;
            prev = null;
            scratch = 0;
        }

        public List<PathEdge> adj(){
            return (List<PathEdge>)(List<?>)this.adj;
        }
    }

    class PathEdge extends Edge {

        public PathEdge(PathNode dest, double cost) {
            super(dest, cost);
        }

        public PathEdge(Edge edge){
            super(edge.dest, edge.cost);
            if(!(edge.dest instanceof PathNode))
                this.dest = new PathNode(this.dest);

        }
    }

}
