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

package it.sijmen.hanasdapp.datalgos.toets1.opgave2;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Sijmen on 15-3-2017.
 */
public class RegexNodeTest {

    @Test
    public void testOpgave2a() throws Exception {
        RegexGraph s0 = new RegexGraph("s0", false);
        RegexGraph s1 = new RegexGraph("s1", true);
        RegexGraph s2 = new RegexGraph("s2", false);
        RegexGraph s3 = new RegexGraph("s3", true);

        s1.addNextNode('d', s3);
        s2.addNextNode('c', s1);
        s1.addNextNode('b', s2);
        s0.addNextNode('a', s1);

        System.out.println(s0);
    }

    @Test
    public void testOpgave2b() throws Exception {
        RegexGraph s0 = new RegexGraph("s0", false);
        RegexGraph s1 = new RegexGraph("s1", true);
        RegexGraph s2 = new RegexGraph("s2", false);
        RegexGraph s3 = new RegexGraph("s3", true);

        s1.addNextNode('d', s3);
        s2.addNextNode('c', s1);
        s1.addNextNode('b', s2);
        s0.addNextNode('a', s1);

        assertTrue(s0.matches("a"));
        assertTrue(s0.matches("abc"));
        assertTrue(s0.matches("abcbcbc"));
        assertTrue(s0.matches("ad"));
        assertTrue(s0.matches("abcd"));
        assertTrue(s0.matches("abcbcd"));

        assertFalse(s0.matches("aaa"));
        assertFalse(s0.matches("abcbd"));
        assertFalse(s0.matches("def"));
        assertFalse(s0.matches("xyyyz"));
        assertFalse(s0.matches("abcdd"));
    }
}