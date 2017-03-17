package it.sijmen.hanasdapp.datalgos.trees.algos;

import it.sijmen.hanasdapp.datalgos.trees.STree;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sijmen on 6-3-2017.
 */
public class AdditionAlgoTest {

    @Test
    public void testAddNumber() throws Exception {
        STree<Integer> tree = new STree<>();
        tree.addNode(10).addNode(10).addNode(10);
        tree.addNode(10).addNode(10);
        tree.addNode(10);

        AdditionAlgo algo = new AdditionAlgo(1);
        algo.apply(tree);

        assertValuesEqual(tree, 11);

    }

    private void assertValuesEqual(STree<Integer> tree, int expected) {
        if(tree.getValue() != null)
            assertEquals(expected, (int)tree.getValue());
        if(tree.hasNodes())
            for(STree<Integer> n : tree.getNodes())
                assertValuesEqual(n, expected);
    }
}