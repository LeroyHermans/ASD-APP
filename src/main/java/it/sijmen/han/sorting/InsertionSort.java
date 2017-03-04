package it.sijmen.han.sorting;

/**
 * Created by Sijmen on 10-2-2017.
 */
public class InsertionSort<T extends Comparable<T>> extends Sorter<T> {

    @Override
    public T[] sort(T[] unsorted) {
        if(unsorted == null || unsorted.length <= 1)
            return unsorted;

        for(int pointer = 1; pointer < unsorted.length; pointer++){
            if(unsorted[pointer].compareTo(unsorted[pointer-1]) < 0)
                for(int subpointer = pointer; subpointer > 0; subpointer--){
                    if(unsorted[subpointer].compareTo(unsorted[subpointer-1]) < 0)
                        rotate(unsorted, subpointer, subpointer-1);
                    else
                        break;
                }
        }
        return unsorted;
    }

    @Override
    public String getName() {
        return "InsertionSort";
    }
}
