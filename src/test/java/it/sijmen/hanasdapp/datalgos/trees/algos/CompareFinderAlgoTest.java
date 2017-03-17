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

import it.sijmen.hanasdapp.datalgos.trees.STree;
import it.sijmen.hanasdapp.datalgos.trees.TreeTestSeeder;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sijmen on 7-3-2017.
 */
public class CompareFinderAlgoTest extends TreeTestSeeder {

    @Test
    public void testCompareAlgoBiggest() throws Exception {
        CompareFinderAlgo<STree<String>, String> biggest = new CompareFinderAlgo<>(
                (o1, o2) -> o1.getValue().compareTo(o2.getValue())
        );
        assertEquals("X", biggest.apply(sTree).getValue());
    }

    @Test
    public void testCompareAlgoSmallest() throws Exception {
        CompareFinderAlgo<STree<String>, String> smallest = new CompareFinderAlgo<>(
                (o1, o2) -> o2.getValue().compareTo(o1.getValue())
        );
        assertEquals("A", smallest.apply(sTree).getValue());
    }
}