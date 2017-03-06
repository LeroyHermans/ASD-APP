package it.sijmen.han.trees.algos;

import it.sijmen.han.trees.AbstractTree;

/**
 * Created by Sijmen on 6-3-2017.
 */
public class HeightAlgo<T> implements TreeAlgorithm<T, Integer> {

    @Override
    public Integer apply(AbstractTree<T> tree) {
        if(tree == null)
            return 0;

        int max = 0;
        AbstractTree<T>[] nodes = tree.getNodes();
        if(nodes != null)
            for(AbstractTree<T> node : nodes)
                max = Integer.max(max, apply(node));

        if(tree.getValue() != null)
            max++;
        return max;
    }

}
