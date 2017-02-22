package it.sijmen.han.sorting;

/**
 * Created by Sijmen on 10-2-2017.
 */
public class InsertionSort extends Sorter {

    @Override
    public int[] sort(int[] unsorted) {
        if(unsorted == null || unsorted.length <= 1)
            return unsorted;

        for(int pointer = 0; smallerthan(pointer, unsorted.length - 1); pointer++){
            if(biggerthan(unsorted[pointer], unsorted[pointer+1]))
                rotate(unsorted, pointer, pointer+1);

            for(int subpointer = pointer-1; biggerequals(subpointer, 0); subpointer--){
                if(biggerthan(unsorted[subpointer], unsorted[subpointer+1]))
                    rotate(unsorted, subpointer, subpointer+1);
                else
                    break;
            }
        }
        return unsorted;
    }
}
