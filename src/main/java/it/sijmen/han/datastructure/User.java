package it.sijmen.han.datastructure;

/**
 * Created by Sijmen on 15-2-2017.
 */
public class User {

    public static void main(String[] args) {
        MyLinkedList<String> arr = new MyLinkedList<>();
        arr.addFirst("5");
        arr.addFirst("4");
        arr.addFirst("3");
        arr.addFirst("2");
        arr.addFirst("1");
        System.out.println(arr);
        arr.delete(2);
        System.out.println(arr);
        arr.insert(2, "3");
        System.out.println(arr);
        arr.removeFirst();
        System.out.println(arr);
    }

}
