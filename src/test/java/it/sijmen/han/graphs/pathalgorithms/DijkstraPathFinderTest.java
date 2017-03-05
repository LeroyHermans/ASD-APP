package it.sijmen.han.graphs.pathalgorithms;

import it.sijmen.han.graphs.SGrah;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sijmen on 5-3-2017.
 */
public class DijkstraPathFinderTest {

    DijkstraPathFinder pathFinder;
    SGrah sGrah;

    @Before
    public void setUp() throws Exception {
        sGrah = new SGrah();

        sGrah.addEdge("A", "B", 3);
        sGrah.addEdge("B", "D", 6);

        sGrah.addEdge("A", "C", 6);
        sGrah.addEdge("C", "D", 2);

        pathFinder = new DijkstraPathFinder(sGrah);
    }

    @Test
    public void testFindPath() throws Exception {
        pathFinder.findPath(sGrah.getNode("A"));
        System.out.println(pathFinder.getPathString(sGrah.getNode("D")));
    }
}