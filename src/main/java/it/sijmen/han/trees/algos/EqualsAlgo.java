package it.sijmen.han.trees.algos;

import it.sijmen.han.trees.AbstractTree;

/**
 * Created by Sijmen on 10-3-2017.
 */
public class EqualsAlgo<T> implements TreeAlgorithm<T, Boolean> {

    AbstractTree<T> baseTree;

    public EqualsAlgo(AbstractTree<T> baseTree) {
        this.baseTree = baseTree;
    }

    @Override
    public Boolean apply(AbstractTree<T> otherTree) {
        return treeEquals(baseTree, otherTree);
    }

    protected boolean treeEquals(AbstractTree<T> a, AbstractTree<T> b){
        if(!valuesEqual(a, b))
            return false;
        AbstractTree<T>[] nodesA = a.getNodes();
        AbstractTree<T>[] nodesB = b.getNodes();
        if(nodesA.length != nodesB.length)
            return false;
        for(int i = 0; i < nodesA.length; i++)
            if(!treeEquals(nodesA[i], nodesB[i]))
                return false;
        return true;
    }

    private boolean valuesEqual(AbstractTree<T> a, AbstractTree<T> b) {
        if(a.getValue() == b.getValue())
            return true;
        if(a.getValue() == null || b.getValue() == null)
            return false;
        return a.getValue().equals(b.getValue());
    }
}
