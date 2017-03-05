package it.sijmen.han.lists;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sijmen on 4-3-2017.
 */
public class SArrayListTest {

    @Test
    public void testGet() throws Exception {
        SArrayList<String> arrayList = new SArrayList<>("A", "B", "C", "D");
        assertEquals("C", arrayList.get(2));
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetNegative() throws Exception {
        SArrayList<String> arrayList = new SArrayList<>("A", "B", "C", "D");
        arrayList.get(-1);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testOver() throws Exception {
        SArrayList<String> arrayList = new SArrayList<>("A", "B", "C", "D");
        arrayList.get(4);
    }

    @Test
    public void testRemoveAtCenter() throws Exception {
        SArrayList<String> arrayList = new SArrayList<>("A", "B", "C", "D");
        arrayList.removeAt(2);
        assertEquals(new SArrayList<>("A", "B", "D"), arrayList);
    }

    @Test
    public void testRemoveAtFirst() throws Exception {
        SArrayList<String> arrayList = new SArrayList<>("A", "B", "C", "D");
        arrayList.removeAt(0);
        assertEquals(new SArrayList<>("B", "C", "D"), arrayList);
    }

    @Test
    public void testRemoveAtLast() throws Exception {
        SArrayList<String> arrayList = new SArrayList<>("A", "B", "C", "D");
        arrayList.removeAt(3);
        assertEquals(new SArrayList<>("A", "B", "C"), arrayList);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testRemoveAtNegative() throws Exception {
        SArrayList<String> arrayList = new SArrayList<>("A", "B", "C", "D");
        arrayList.removeAt(-1);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testRemoveAtOver() throws Exception {
        SArrayList<String> arrayList = new SArrayList<>("A", "B", "C", "D");
        arrayList.removeAt(4);
    }

    @Test
    public void testSetCenter() throws Exception {
        SArrayList<String> arrayList = new SArrayList<>("A", "B", "C", "D");
        arrayList.set(2, "1");
        assertEquals(new SArrayList<>("A", "B", "1", "D"), arrayList);
    }

    @Test
    public void testSetFirst() throws Exception {
        SArrayList<String> arrayList = new SArrayList<>("A", "B", "C", "D");
        arrayList.set(0, "1");
        assertEquals(new SArrayList<>("1", "B", "C", "D"), arrayList);
    }

    @Test
    public void testSetLast() throws Exception {
        SArrayList<String> arrayList = new SArrayList<>("A", "B", "C", "D");
        arrayList.set(3, "1");
        assertEquals(new SArrayList<>("A", "B", "C", "1"), arrayList);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testSetOver() throws Exception {
        SArrayList<String> arrayList = new SArrayList<>("A", "B", "C", "D");
        arrayList.set(4, "1");
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testSetNegative() throws Exception {
        SArrayList<String> arrayList = new SArrayList<>("A", "B", "C", "D");
        arrayList.set(-1, "1");
    }

    @Test
    public void testLength() throws Exception {
        SArrayList<String> arrayList = new SArrayList<>("A", "B", "C", "D");
        assertEquals(4, arrayList.length());
    }

    @Test
    public void testLengthZero() throws Exception {
        SArrayList<String> arrayList = new SArrayList<>();
        assertEquals(0, arrayList.length());
    }

    @Test
    public void testLengthAdded() throws Exception {
        SArrayList<String> arrayList = new SArrayList<>("A", "B", "C", "D");
        arrayList.add("E");
        assertEquals(5, arrayList.length());
    }

    @Test
    public void testLengthRemoved() throws Exception {
        SArrayList<String> arrayList = new SArrayList<>("A", "B", "C", "D");
        arrayList.removeAt(3);
        assertEquals(3, arrayList.length());
    }

    @Test
    public void testAddConstructorInitialized() throws Exception {
        SArrayList<String> arrayList = new SArrayList<>("A", "B", "C", "D");
        arrayList.add("E");
        assertEquals(new SArrayList<>("A", "B", "C", "D", "E"), arrayList);
    }

    @Test
    public void testAddEmpty() throws Exception {
        SArrayList<String> arrayList = new SArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        assertEquals(new SArrayList<>("A", "B", "C"), arrayList);
    }

    @Test
    public void testAddInitialLength() throws Exception {
        SArrayList<String> arrayList = new SArrayList<>(2);
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        assertEquals(new SArrayList<>("A", "B", "C", "D"), arrayList);
    }
}