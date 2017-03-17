package it.sijmen.hanasdapp.datalgos.trees.algos;

import it.sijmen.hanasdapp.datalgos.trees.TreeTestSeeder;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sijmen on 6-3-2017.
 */
public class HeightAlgoTest extends TreeTestSeeder{

    @Test
    public void testgetHeightSTree() throws Exception {
       assertEquals(4, sTree.getHeight());
    }

    @Test
    public void testgetHeightBinaryTree() throws Exception {
        assertEquals(4, binaryTree.getHeight());
    }


}