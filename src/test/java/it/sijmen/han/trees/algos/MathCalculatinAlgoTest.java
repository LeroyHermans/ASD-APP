package it.sijmen.han.trees.algos;

import it.sijmen.han.trees.SBinaryTree;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sijmen on 7-3-2017.
 */
public class MathCalculatinAlgoTest {

    MathCalculatinAlgo algo = new MathCalculatinAlgo();

    @Test
    public void testApplySingleLayer() throws Exception {
        SBinaryTree<String> tree = new SBinaryTree<>("+");

        tree.left("10");
        tree.right("10");

        assertEquals((Integer)20, algo.apply(tree));
    }

    @Test
    public void testApplyTwoLayers() throws Exception {
        SBinaryTree<String> tree = new SBinaryTree<>("*");

        tree.left("10");
        SBinaryTree<String> right = tree.right("+");
        right.left("5");
        right.right("5");

        assertEquals((Integer) 100, algo.apply(tree));
    }

    @Test
    public void testAppllySumAdd(){
        assertEquals(10, algo.calculateSom("+", 5, 5));
    }

    @Test
    public void testAppllySumSubtract(){
        assertEquals(0, algo.calculateSom("-", 5, 5));
    }

    @Test
    public void testAppllySumMultiply(){
        assertEquals(25, algo.calculateSom("*", 5, 5));
    }

    @Test
    public void testAppllySumDevide(){
        assertEquals(2, algo.calculateSom("/", 10, 5));
    }
}