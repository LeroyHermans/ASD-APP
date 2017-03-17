package it.sijmen.hanasdapp.datalgos.trees.algos;

import it.sijmen.hanasdapp.datalgos.trees.AbstractTree;

/**
 * Calculates the full sieze of the tree. Counts all elements
 * including the top element that contain a not-null value.
 *
 * Created by Sijmen on 6-3-2017.
 */
public class SizeAlgo<T> implements TreeAlgorithm<T, Integer> {

    @Override
    public Integer apply(AbstractTree<T> tree) {
        if(tree == null)
            return 0;
        int i = 0;
        if(tree.getValue() != null)
            i++;
        AbstractTree<T>[] nodes = tree.getNodes();
        if(nodes != null)
            for(AbstractTree<T> node : nodes)
                i+=apply(node);
        return i;
    }

}
