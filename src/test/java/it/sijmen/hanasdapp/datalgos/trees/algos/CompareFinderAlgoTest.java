package it.sijmen.hanasdapp.datalgos.trees.algos;

import it.sijmen.hanasdapp.datalgos.trees.STree;
import it.sijmen.hanasdapp.datalgos.trees.TreeTestSeeder;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sijmen on 7-3-2017.
 */
public class CompareFinderAlgoTest extends TreeTestSeeder {

    @Test
    public void testCompareAlgoBiggest() throws Exception {
        CompareFinderAlgo<STree<String>, String> biggest = new CompareFinderAlgo<>(
                (o1, o2) -> o1.getValue().compareTo(o2.getValue())
        );
        assertEquals("X", biggest.apply(sTree).getValue());
    }

    @Test
    public void testCompareAlgoSmallest() throws Exception {
        CompareFinderAlgo<STree<String>, String> smallest = new CompareFinderAlgo<>(
                (o1, o2) -> o2.getValue().compareTo(o1.getValue())
        );
        assertEquals("A", smallest.apply(sTree).getValue());
    }
}