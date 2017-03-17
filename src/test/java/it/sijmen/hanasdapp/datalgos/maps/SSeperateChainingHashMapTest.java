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

package it.sijmen.hanasdapp.datalgos.maps;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Sijmen on 4-3-2017.
 */
public class SSeperateChainingHashMapTest {

    SSeperateChainingHashMap<Integer, String> emptyMap;
    SSeperateChainingHashMap<Integer, String> abcdMap;

    @Before
    public void setUp() throws Exception {
        emptyMap = new SSeperateChainingHashMap<>();
        abcdMap = new SSeperateChainingHashMap<>();
        abcdMap.put(10, "10");
        abcdMap.put(20, "20");
        abcdMap.put(11, "11");
        abcdMap.put(21, "21");
    }

    @Test
    public void testSize() throws Exception {
        assertEquals(0, emptyMap.size());
        assertEquals(4, abcdMap.size());
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertTrue(emptyMap.isEmpty());
        assertFalse(abcdMap.isEmpty());
    }

    @Test
    public void testContainsKey() throws Exception {
        assertFalse(emptyMap.containsKey(10));
        assertFalse(abcdMap.containsKey(30));
        assertTrue(abcdMap.containsKey(10));
    }

    @Test
    public void testContainsValue() throws Exception {
        assertFalse(emptyMap.containsValue("1"));
        assertFalse(abcdMap.containsValue("0"));
        assertTrue(abcdMap.containsValue("20"));
    }

    @Test
    public void testGet() throws Exception {
        assertEquals("10", abcdMap.get(10));
        assertEquals("11", abcdMap.get(11));
        assertEquals("20", abcdMap.get(20));
        assertEquals("21", abcdMap.get(21));
    }

    @Test
    public void testGetNull() throws Exception{
        assertNull(emptyMap.get(10));
        assertNull(abcdMap.get(100));
    }

    @Test
    public void testPut() throws Exception {
        emptyMap.put(100, "100");
        assertEquals("100", emptyMap.get(100));
        emptyMap.put(100, "hunderd");
        assertEquals("hunderd", emptyMap.get(100));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPutNull() throws Exception {
        emptyMap.put(null, "100");
    }

    @Test //LastInBucket
     public void testRemove() throws Exception {
        assertEquals("20", abcdMap.remove(20));
        assertNull(abcdMap.get(20));
        assertEquals("10", abcdMap.get(10));
    }

    @Test
    public void testRemoveFirstInBucket() throws Exception {
        assertEquals("10", abcdMap.remove(10));
        assertNull(abcdMap.get(10));
        assertEquals("20", abcdMap.get(20));
    }

    @Test
    public void testRemoveEmpty() throws Exception {
        assertNull(emptyMap.remove(100));
    }

    @Test
    public void testPutAll() throws Exception {
        emptyMap.putAll(abcdMap);
        assertEquals("10", emptyMap.get(10));
        assertEquals("11", emptyMap.get(11));
        assertEquals("20", emptyMap.get(20));
        assertEquals("21", emptyMap.get(21));
    }

    @Test
    public void testClear() throws Exception {
        abcdMap.clear();
        assertEquals(0, abcdMap.size());
    }

    @Test
    public void testKeySet() throws Exception {
        Integer[] integers = abcdMap.keySet().toArray(new Integer[4]);
        Arrays.sort(integers);
        assertArrayEquals(new Integer[]{10, 11, 20, 21}, integers);
    }
}