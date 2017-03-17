package it.sijmen.hanasdapp.datalgos.trees;

import org.junit.Before;

/**
 * Created by Sijmen on 6-3-2017.
 */
public class TreeTestSeeder {

    protected STree<String> sTree;
    protected SBinaryTree<String> binaryTree;

    @Before
    public void setUp(){
        sTree = new STree<>("X");

        STree<String> a = sTree.addNode("A");
        a.addNode("B");
        STree<String> c = a.addNode("C");
        c.addNode("D");
        c.addNode("E");
        c.addNode("F");

        STree<String> d = sTree.addNode("GGGGGGGG");
        d.addNode("H");
        STree<String> f = d.addNode("IIIIIIII");
        f.addNode("JJJJJJJ");
        f.addNode("K");
        f.addNode("L");


        binaryTree = new SBinaryTree<>("X");
        SBinaryTree<String> ab = binaryTree.left("A");
        ab.left("B");
        SBinaryTree<String> cc = ab.right("C");
        cc.left("D");
        cc.right("E");
        binaryTree.right("GGGGGGGG");
    }

}
