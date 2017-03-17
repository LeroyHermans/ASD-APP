package it.sijmen.hanasdapp.datalgos.trees.algos;

import it.sijmen.hanasdapp.datalgos.trees.AbstractTree;

/**
 * Created by Sijmen on 6-3-2017.
 */
public class AdditionAlgo implements TreeAlgorithm<Integer, AbstractTree<Integer>> {

    private Integer amount;

    public AdditionAlgo(Integer amount) {
        this.amount = amount;
    }

    @Override
    public AbstractTree<Integer> apply(AbstractTree<Integer> tree) {
        if(tree == null)
            return tree;

        if(tree.getValue() != null)
            tree.setValue(tree.getValue() + this.amount);
        AbstractTree<Integer>[] nodes = tree.getNodes();
        if(nodes != null)
            for(AbstractTree<Integer> node : nodes)
                this.apply(node);

        return tree;
    }

}
