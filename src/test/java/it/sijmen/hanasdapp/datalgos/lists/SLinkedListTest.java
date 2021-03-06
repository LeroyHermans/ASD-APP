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

package it.sijmen.hanasdapp.datalgos.lists;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sijmen on 4-3-2017.
 */
public class SLinkedListTest {

    SLinkedList<String> emptyList;
    SLinkedList<String> abcdList;

    @Before
    public void before(){
        emptyList = new SLinkedList<>();
        abcdList = new SLinkedList<>("A", "B", "C", "D");
    }

    private void testEquals(SLinkedList<String> list, String... expected){
        assertEquals(new SLinkedList<>(expected), list);
    }

    @Test
    public void testAddFirst() throws Exception {
        emptyList.addFirst("C");
        emptyList.addFirst("B");
        emptyList.addFirst("A");
        testEquals(emptyList, "A", "B", "C");
    }

    @Test
    public void testRemoveFirst() throws Exception {
        abcdList.removeFirst();
        testEquals(abcdList, "B", "C", "D");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveEmpty() throws Exception {
        emptyList.removeFirst();
    }

    @Test
    public void testInsert() throws Exception {
        abcdList.insert(2, "B1");
        testEquals(abcdList, "A", "B", "B1", "C", "D");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertEmpty() throws Exception {
        emptyList.insert(1, "A");
    }

    @Test
    public void testInsertEmptyZero() throws Exception {
        emptyList.insert(0, "A");
        testEquals(emptyList, "A");
    }

    @Test
    public void testInsertZero() throws Exception {
        abcdList.insert(0, "0");
        testEquals(abcdList, "0", "A", "B", "C", "D");
    }

    @Test
    public void testInsertMax() throws Exception {
        abcdList.insert(4, "E");
        testEquals(abcdList, "A", "B", "C", "D", "E");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testInsertOutOFBound() throws Exception {
        abcdList.insert(5, "E");
        testEquals(abcdList, "A", "B", "C", "D");
    }

    @Test
    public void testDelete() throws Exception {
        abcdList.delete(2);
        testEquals(abcdList, "A", "B", "D");
    }

    @Test
    public void testDeleteEnd() throws Exception {
        abcdList.delete(3);
        testEquals(abcdList, "A", "B", "C");
    }

    @Test
    public void testDeleteStart() throws Exception {
        abcdList.delete(0);
        testEquals(abcdList, "B", "C", "D");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeleteOverEnd() throws Exception {
        abcdList.delete(4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeleteNegative() throws Exception {
        abcdList.delete(-1);
    }

    @Test
    public void testGet() throws Exception {
        assertEquals("B", abcdList.get(1));
    }

    @Test
    public void testGetZero() throws Exception {
        assertEquals("A", abcdList.get(0));
    }

    @Test
    public void testGetMax() throws Exception {
        assertEquals("D", abcdList.get(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetOutOfBound() throws Exception {
        abcdList.get(4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetNegative() throws Exception {
        abcdList.get(-1);
    }

    @Test
    public void testGetLength(){
        assertEquals(4, abcdList.getLenght());
    }

    @Test
    public void testGetLengthEmpty(){
        assertEquals(0, emptyList.getLenght());
    }
}