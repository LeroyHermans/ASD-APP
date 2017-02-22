package it.sijmen.han.sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Sijmen on 10-2-2017.
 */
public class MergeSort extends Sorter {
    @Override
    public int[] sort(int[] unsorted) {
        return mergesort(unsorted);
    }

    public int[] mergesort(int[] array){
        if(array.length <= 1)
            return array;
        if(array.length <= 2) {
            if(array[0] <= array[1])
                return array;
            return new int[]{array[1], array[0]};
        }

        return merge(
                mergesort(Arrays.copyOfRange(array, 0, array.length / 2)),
                mergesort(Arrays.copyOfRange(array, array.length/2, array.length))
        );
    }

    public int[] merge(int[] arr1, int[] arr2){
        int[] arrOut = new int[arr1.length + arr2.length];

        int arr1I = 0, arr2I = 0;

        for(int i = 0; i < arrOut.length; i++){
            if(arr1I >= arr1.length){ // als arr1 leeg is, pak van 2
                arrOut[i] = arr2[arr2I];
                arr2I++;
            }
            else if(arr2I >= arr2.length){ // als arr2 leeg is, pak van 1
                arrOut[i] = arr1[arr1I];
                arr1I++;
            }
            else if(arr1[arr1I] <= arr2[arr2I]) { //pak van de laagste: 1
                arrOut[i] = arr1[arr1I];
                arr1I++;
            }
            else{ //pak van de laagste: 2
                arrOut[i] = arr2[arr2I];
                arr2I++;
            }
        }
        return arrOut;
    }
}
