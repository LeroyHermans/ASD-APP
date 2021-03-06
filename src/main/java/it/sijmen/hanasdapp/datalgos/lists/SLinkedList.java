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

/**
 * Sijmens Linked List
 * Created by Sijmen on 15-2-2017.
 */
public class SLinkedList<T> {

    private Node<T> header = null;
    private int lenght = 0;

    public SLinkedList() {
    }

    @SafeVarargs
    public SLinkedList(T... data) {
        for(int i = data.length-1; i >= 0; i--)
            addFirst(data[i]);
    }

    public void addFirst(T value){
        header = new Node<>(value, header);
        lenght++;
    }

    public T removeFirst(){
        if(header == null)
            throw new IndexOutOfBoundsException();
        T removed = header.element;
        header = header.next; //is checked!
        lenght--;
        return removed;
    }

    /**
     * Inserts an item at the given index and
     * moves all items after this item (including the item
     * on the given posiiton) one position higher.
     * @param index where to insert
     * @param value the value to insert
     */
    public void insert(int index, T value){
        if(index == 0){
            addFirst(value);
            return;
        }

        if(index > lenght || index < 0)
            throw new IndexOutOfBoundsException();

        int i = 0;
        Node element = header;
        while(i != index-1){
            element = element.next;
            i++;
        }
        element.next = new Node<>(value, element.next);
        lenght++;
    }

    public void delete(int index){
        if(index == 0) {
            removeFirst();
            return;
        }

        if(index >= lenght || index < 0)
            throw new IndexOutOfBoundsException();

        int i = 0;
        Node element = header;
        while(i != index-1){
            element = element.next;
            i++;
        }
        if(element.next == null)
            throw new IndexOutOfBoundsException();
        element.next = element.next.next;
        lenght--;
    }

    public T get(int index){
        int i = 0;
        Node<T> element = header;
        while(i != index){
            if(!element.hasNext())
                throw new IndexOutOfBoundsException();
            element = element.next; //is checked!
            i++;
        }
        return element.element;
    }

    public int getLenght(){
        return lenght;
    }

    public String dataToString(){
        return "data=[" + header;
    }

    @Override
    public String toString() {
        return "SLinkedList{" +
                dataToString() +
                ", lenght=" + lenght +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SLinkedList)) return false;

        SLinkedList<?> that = (SLinkedList<?>) o;

        if (this.lenght != that.lenght)
            return false;

        return header == null ? that.header == null : header.equals(that.header);

    }

    @Override
    public int hashCode() {
        int result = header != null ? header.hashCode() : 0;
        result = 31 * result + lenght;
        return result;
    }

    static class Node<E> {
        private E element;
        private Node next;

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }

        public boolean hasNext() {
            return next != null;
        }

        public int length(){
            int c = 0;
            Node element = this;
            while(element.hasNext()){
                element = element.next;
                c++;
            }
            return c;
        }

        @Override
        public String toString() {
            return element + (hasNext() ? (", " + next) : "]");
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node))
                return false;

            Node that = (Node) o;

            if (!this.element.equals(that.element))
                return false;

            return next == null ? that.next == null : next.equals(that.next);
        }

        @Override
        public int hashCode() {
            int result = element.hashCode();
            result = 31 * result + (next != null ? next.hashCode() : 0);
            return result;
        }
    }

}
