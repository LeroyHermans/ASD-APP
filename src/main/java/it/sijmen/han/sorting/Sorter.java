package it.sijmen.han.sorting;

/**
 * Created by Sijmen on 10-2-2017.
 */
public abstract class Sorter<T extends Comparable<T>> {

    public abstract T[] sort(T[] unsorted);
    public abstract String getName();

    protected <S> S[] rotate(S[] array, int index1, int index2){
        S tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
        return array;
    }
}
