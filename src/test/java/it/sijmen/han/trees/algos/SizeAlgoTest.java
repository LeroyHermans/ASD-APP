package it.sijmen.han.trees.algos;

import it.sijmen.han.trees.TreeTestSeeder;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sijmen on 6-3-2017.
 */
public class SizeAlgoTest extends TreeTestSeeder {

    @Test
    public void testGetSizesSTree() throws Exception {
        SizeAlgo<String> algo = new SizeAlgo<>();
        assertEquals(13, (int)algo.apply(sTree));
    }

    @Test
    public void testGetSizesBinaryTree() throws Exception {
        SizeAlgo<String> algo = new SizeAlgo<>();
        assertEquals(7, (int) algo.apply(binaryTree));
    }
}