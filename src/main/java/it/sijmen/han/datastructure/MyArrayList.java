package it.sijmen.han.datastructure;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Sijmen on 15-2-2017.
 */
public class MyArrayList<T> implements Iterable<T>{

    private Object[] data;

    private int length = 0;

    public MyArrayList(int length) {
        this.data = new Object[length];
    }

    public MyArrayList(){
        this(0);
    }

    public int add(T obj){
        synchronized (this){
            if(data.length == length){
                Object[] old = data;
                data = new Object[data.length*2+1];
                System.arraycopy(old, 0, data, 0, old.length);
            }
            data[length] = obj;
            return length++;
        }
    }

    public void remove(int index){
        synchronized (this) {
            if(index > length-1 || index < 0)
                throw new IndexOutOfBoundsException();
            System.arraycopy(data, index + 1, data, index, length - 1 - index);
            length--;
        }
    }

    public void set(int index, T value){
        if(index > length-1 || index < 0)
            throw new IndexOutOfBoundsException();
        data[index] = value;
    }

    public int length(){
        return length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyArrayList<?> that = (MyArrayList<?>) o;

        if (length != that.length) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(data);
        result = 31 * result + length;
        return result;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "data=" + arrayToString() +
                ", length=" + length +
                '}';
    }

    private String arrayToString(){
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
