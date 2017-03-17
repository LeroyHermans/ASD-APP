package it.sijmen.hanasdapp.datalgos.sorting;

/**
 * Created by Sijmen on 10-2-2017.
 */
public class QuickSort<T extends Comparable<T>> extends Sorter<T> {

    @Override
    public T[] sort(T[] unsorted) {
        if(unsorted == null || unsorted.length <= 1)
            return unsorted;
        return quicksort(unsorted, 0, unsorted.length-1);
    }

    @Override
    public String getName() {
        return "QuickSort";
    }

    public T[] quicksort(T[] unsorted, int lowIndex, int highIndex){
        T pivot = unsorted[lowIndex+(highIndex-lowIndex)/2];

        int indexL = lowIndex, indexR = highIndex;

        while(indexL <= indexR){
            while(unsorted[indexL].compareTo(pivot) < 0)
                indexL++;
            while(unsorted[indexR].compareTo(pivot) > 0)
                indexR--;
            if(indexL <= indexR) {
                if(unsorted[indexL] != unsorted[indexR])
                    rotate(unsorted, indexL, indexR);

                indexL++;
                indexR--;
            }
        }

        if (lowIndex < indexR)
            quicksort(unsorted, lowIndex, indexR);
        if (indexL < highIndex)
            quicksort(unsorted, indexL, highIndex);

        return unsorted;
    }
}
