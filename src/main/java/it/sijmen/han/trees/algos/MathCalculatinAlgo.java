package it.sijmen.han.trees.algos;

import it.sijmen.han.trees.AbstractTree;
import it.sijmen.han.trees.SBinaryTree;

/**
 * Created by Sijmen on 7-3-2017.
 */
public class MathCalculatinAlgo implements TreeAlgorithm<String, Integer> {

    @Override
    public Integer apply(AbstractTree<String> tree) {
        if(tree == null)
            return 0;
        if (!(tree instanceof SBinaryTree))
            throw new IllegalArgumentException();

        SBinaryTree<String> stree = (SBinaryTree<String>) tree;

        if(stree.hasLeft() != stree.hasRight())
            throw new IllegalStateException("Left and Right should be the same.");

        if(stree.hasLeft())
            return calculateSom(tree.getValue(),
                    apply(stree.left()),
                    apply(stree.right()));

        else
            return Integer.parseInt(tree.getValue());
    }

    int calculateSom(String operator, int left, int right) {
        switch (operator){
            case "+": return left + right;
            case "-": return left - right;
            case "/": return left / right;
            case "*": return left * right;
            default: throw new IllegalStateException("Illegal operator '" + operator + "'");
        }
    }

}
