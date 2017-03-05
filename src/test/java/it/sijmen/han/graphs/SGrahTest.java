package it.sijmen.han.graphs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sijmen on 5-3-2017.
 */
public class SGrahTest {

    /**
     *     -> C
     *   A      -> D
     *     -> B
     */
    SGrah abcdGrah;

    /**
     *     -> C
     *   A      -> D  <- E
     *     -> B
     *  /\
     *  |
     *  F
     */
    SGrah abcdefGrah;

    /**
     *    a -> b
     *
     *    q
     */
    SGrah abqGrah;

    @Before
    public void setUp() throws Exception {
        abcdGrah = new SGrah();
        abcdGrah.addEdge("A", "B", 3);
        abcdGrah.addEdge("B", "D", 6);
        abcdGrah.addEdge("A", "C", 6);
        abcdGrah.addEdge("C", "D", 2);

        abcdefGrah = new SGrah();
        abcdefGrah.addEdge("A", "B", 3);
        abcdefGrah.addEdge("B", "D", 6);
        abcdefGrah.addEdge("A", "C", 6);
        abcdefGrah.addEdge("C", "D", 2);
        abcdefGrah.addEdge("F", "A", 5);
        abcdefGrah.addEdge("E", "D", 4);

        abqGrah = new SGrah();
        abqGrah.addEdge("A", "B", 10);
        abqGrah.getAndAddNode("Q");
    }

    @Test
    public void testIsConnectedStrong() throws Exception {
        assertTrue(abcdGrah.isConnected());
    }

    @Test
    public void testIsConnectedWeak() throws Exception {
        assertTrue(abcdefGrah.isConnected());
    }

    @Test
    public void testIsConnectedNot() throws Exception {
        assertFalse(abqGrah.isConnected());
    }
}