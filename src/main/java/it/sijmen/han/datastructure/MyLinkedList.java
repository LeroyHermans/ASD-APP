package it.sijmen.han.datastructure;

/**
 * Created by Sijmen on 15-2-2017.
 */
public class MyLinkedList<T> {

    private Node header;
    private int lenght;

    void addFirst(T value){
        header = new Node(value, header);
        lenght++;
    }

    void removeFirst(){
        header = header.next;
        lenght--;
    }

    void insert(int index, T value){
        int i = 0;
        Node element = header;
        while(i != index){
            if(!element.hasNext())
                throw new ArrayIndexOutOfBoundsException();
            i++;
        }
        if(!element.hasNext())
            throw new ArrayIndexOutOfBoundsException();
        element.next = new Node(value, element.next);
        lenght++;
    }

    void delete(int index){
        int curIndex = 0;
        Node element = header;
        while(curIndex != index+1)
            curIndex++;
        element.next = element.next.next;
        lenght--;
    }

    T get(int index){
        int i = 0;
        Node element = header;
        while(i != index){
            if(!element.hasNext())
                throw new ArrayIndexOutOfBoundsException();
            element = element.next;
            i++;
        }
        return element.element;
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "data=[" + header +
                ", lenght=" + lenght +
                '}';
    }

    class Node {
        private T element;
        private Node next;

        public Node(T element, Node next) {
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
    }

}
