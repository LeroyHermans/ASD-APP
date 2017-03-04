package it.sijmen.han.lists;

/**
 * Sijmens Stack
 * #untested
 * Created by Sijmen on 15-2-2017.
 */
public class SStack<T> {

    private SLinkedList<T> list;

    public SStack() {
        list = new SLinkedList<>();
    }

    public T top(){
        return list.get(0);
    }

    public T pop(){
        return list.removeFirst();
    }

    public void push(T object){
        list.addFirst(object);
    }

    public int getSize(){
        return list.getLenght();
    }

    @Override
    public String toString() {
        return "SStack{" +
                list.dataToString()+
                '}';
    }
}
