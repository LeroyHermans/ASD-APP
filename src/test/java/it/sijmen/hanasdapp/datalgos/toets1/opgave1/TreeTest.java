package it.sijmen.hanasdapp.datalgos.toets1.opgave1;

import org.junit.Test;

/**
 * Created by Sijmen on 15-3-2017.
 */
public class TreeTest {

    protected Tree<Integer> makeOpgave1Tree(){
        Tree<Integer> tree = new Tree<>(17);
        Tree<Integer> leaf12 = tree.addNode(12);
        Tree<Integer> leaf33 = tree.addNode(33);
        leaf12.addNode(7);
        leaf12.addNode(24);
        leaf12.addNode(5);
        leaf33.addNode(15);
        leaf33.addNode(58);
        return tree;
    }

    @Test
    public void testOpgave1a() throws Exception {
        Tree<Integer> tree = makeOpgave1Tree();
        System.out.println(tree);
    }

    @Test
    public void testOpgave1b() throws Exception {
        Tree<Integer> tree = makeOpgave1Tree();
        tree.removeNodesGreaterOrEqualTo(15);
        System.out.println(tree);
    }

    @Test
    public void testOpageve1c() throws Exception {
        Tree<Integer> tree = makeOpgave1Tree();
        tree.removeMaximum();
        tree.removeMaximum();
        tree.removeMaximum();
        System.out.println(tree);
    }


}