package it.sijmen.han.trees;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sijmen on 10-3-2017.
 */
public class SAVLTreeBuilderTest {

    @Test
    public void test(){
        SAVLTree<String> tree = SAVLTreeBuilder.build(
                root -> {
                    root.value("10");
                    root.left(left -> {
                        left.value("a");
                        left.left("b");
                        left.right(leftright -> {
                            leftright.value("x");
                            leftright.left("xa");
                            leftright.right("ax");
                        });
                    });
                    root.right(right -> {
                        right.value("z");
                        right.left("a");
                        right.right("c");
                    });
                }
        );
        System.out.println(tree);
    }

}