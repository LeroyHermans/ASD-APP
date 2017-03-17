package it.sijmen.hanasdapp.datalgos.trees.algos;

import it.sijmen.hanasdapp.datalgos.trees.AbstractTree;

import java.util.Comparator;

/**
 * Created by Sijmen on 7-3-2017.
 */
public class CompareFinderAlgo<U extends AbstractTree<T>, T> implements TreeAlgorithm<T, U> {

    private Comparator<U> comparator;

    public CompareFinderAlgo(Comparator<U> comparator) {
        this.comparator = comparator;
    }

    U max = null;

    @Override
    public U apply(AbstractTree<T> tree) {
        U cur = (U) tree;

        if(max == null)
            max = cur;
        else
            max = comparator.compare(max, cur) > 0 ? max  : cur;

        if(cur.getNodes() != null){
            for(AbstractTree<T> n : cur.getNodes())
                apply(n);
        }
        return max;
    }
}
