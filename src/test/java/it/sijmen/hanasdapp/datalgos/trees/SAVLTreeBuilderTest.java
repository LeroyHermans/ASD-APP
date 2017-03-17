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

package it.sijmen.hanasdapp.datalgos.trees;

import org.junit.Test;

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