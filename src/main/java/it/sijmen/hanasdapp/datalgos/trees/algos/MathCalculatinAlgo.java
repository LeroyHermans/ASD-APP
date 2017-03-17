/*
 * MIT License
 *
 * Copyright (c) 2017 Sijmen Huizenga
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package it.sijmen.hanasdapp.datalgos.trees.algos;

import it.sijmen.hanasdapp.datalgos.trees.AbstractTree;
import it.sijmen.hanasdapp.datalgos.trees.SBinaryTree;

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
