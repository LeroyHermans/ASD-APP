package it.sijmen.han.lists;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Sijmens Array List
 * Created by Sijmen on 15-2-2017.
 */
public class SArrayList<T> implements Iterable<T> {

    private Object[] data;

    private int length = 0;

    public SArrayList(int length) {
        this.data = new Object[length];
    }

    public SArrayList(){
        this(0);
    }

    @SafeVarargs
    public SArrayList(T... data){
        this.data = data;
        this.length = data.length;
    }

    /**
     * Voeg toe aan het einde
     */
    public int add(T obj){
        if(data.length == length)
            duplicateSize();
        data[length] = obj;
        return length++;
    }

    private void duplicateSize(){
        increaseSize(data.length*2+1);
    }

    private void increaseSize(int size){
        Object[] old = data;
        data = new Object[size];
        System.arraycopy(old, 0, data, 0, old.length);
    }

    /**
     * Geef element op index
     */
    public T get(int index){
        if(index < 0 || index > length -1)
            throw new IndexOutOfBoundsException();
        return (T) data[index];
    }

    /**
     * Verwijder element op index. Alle element ná deze index
     * worden 1 plek naar links geschoven.
     */
    public T remove(int index){
        if(index > length-1 || index < 0)
            throw new IndexOutOfBoundsException();
        Object toRemove = data[index];
        System.arraycopy(data, index + 1, data, index, length - 1 - index);
        length--;
        return (T) toRemove;
    }

    /**
     * Zet een bepaalde index naar een bepaalde waarde
     */
    public void set(int index, T value){
        if(index < 0 || index > length-1)
            throw new IndexOutOfBoundsException();
        data[index] = value;
    }

    /**
     * Huidige lengte
     */
    public int length(){
        return length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SArrayList<?> that = (SArrayList<?>) o;

        if (length != that.length) return false;
        if (this.data==that.data) return true;
        if (this.data==null || that.data==null) return false;

        for (int i=0; i<length; i++) {
            if (!(this.data[i]==null ? that.data[i]==null : this.data[i].equals(that.data[i])))
                return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(data);
        result = 31 * result + length;
        return result;
    }

    @Override
    public String toString() {
        return "SArrayList{" +
                "data=" + arrayToString() +
                ", length=" + length +
                '}';
    }

    /**
     * Alleen het array gedeelte naar een string omzetten inclusief '[' en ']'
     * @return
     */
    public String arrayToString(){
        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(data[i]);
            if(i == length-1)
                return b.append(']').toString();
            b.append(", ");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }

    class MyArrayListIterator implements Iterator<T> {
        int index = -1;

        @Override
        public boolean hasNext() {
            return index < length-1;
        }

        @Override
        public T next() {
            index++;
            return (T) data[index];
        }
    }
}
