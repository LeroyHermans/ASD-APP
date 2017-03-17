/*
 * MIT License
 *
 * Copyright (c) 2017 Sijmen Huizenga
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package it.sijmen.hanasdapp.datalgos.graphs;

import it.sijmen.hanasdapp.datalgos.lists.SArrayList;
import it.sijmen.hanasdapp.datalgos.maps.SSeperateChainingHashMap;

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
     * Are all nodes in this graph connected. The direction is ignored.
     */
    public boolean isConnected(){
        if(nodes.size() <= 1)
            return true;
        Collection<Node> connectedNodes = new SArrayList<>();
        connectedNodes.add((Node) nodes.values().toArray()[0]);

        boolean addedOne;
        do {
            addedOne = false;
            unconnectedloop:
            for (Node checkingNode : nodes.values()) {
                for (Edge edge : checkingNode.adj) {
                    //if you fall in the group of connected nodes,
                    //add all the nodes that are referenced by it
                    if(connectedNodes.contains(checkingNode)){
                        if(!connectedNodes.contains(edge.dest)) {
                            connectedNodes.add(edge.dest);
                            addedOne = true;
                        }
                    }else{
                        //go through all the connected nodes
                        //and see if there is an node that the current
                        //edge references. So yes, add it
                        for (Node connectedNode : connectedNodes) {
                            if (edge.dest == connectedNode) {
                                if(!connectedNodes.contains(checkingNode)){
                                    connectedNodes.add(checkingNode);
                                    addedOne = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }while(addedOne);

        return connectedNodes.size() == nodes.size();
    }

}
