package it.sijmen.hanasdapp.datalgos.trees.algos;

import it.sijmen.hanasdapp.datalgos.trees.TreeTestSeeder;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sijmen on 6-3-2017.
 */
public class SizeAlgoTest extends TreeTestSeeder {

    @Test
    public void testGetSizesSTree() throws Exception {
        assertEquals(13, sTree.getSize());
    }

    @Test
    public void testGetSizesBinaryTree() throws Exception {
        assertEquals(7, binaryTree.getSize());
    }
}