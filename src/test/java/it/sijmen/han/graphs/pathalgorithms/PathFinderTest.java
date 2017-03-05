package it.sijmen.han.graphs.pathalgorithms;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import it.sijmen.han.graphs.SGrah;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by Sijmen on 5-3-2017.
 */
@RunWith(DataProviderRunner.class)
public class PathFinderTest {

    static PathFinder[] finders;

    static SGrah abcdGrah;

    @BeforeClass
    public static void setUp() throws Exception {
        abcdGrah = new SGrah();

        abcdGrah.addEdge("A", "B", 3);
        abcdGrah.addEdge("B", "D", 6);

        abcdGrah.addEdge("A", "C", 6);
        abcdGrah.addEdge("C", "D", 2);

        finders = new PathFinder[]{
                new DijkstraPathFinder(abcdGrah),
                new UnweightedPathFinder(abcdGrah)
        };
    }

    @DataProvider
    public static Object[][] provideFindPath(){
        return new Object[][]{
                finders
        };
    }

    @Test
    @UseDataProvider("provideFindPath")
    public void testFindPath(PathFinder finder) throws Exception {
        finder.findPath(abcdGrah.getNode("A"));

        assertEquals("A->3.0->B->6.0->D", finder.getPathString(abcdGrah.getNode("D")));
    }
}