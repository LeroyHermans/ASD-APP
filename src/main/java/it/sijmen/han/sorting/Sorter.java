package it.sijmen.han.sorting;

import java.util.Arrays;

/**
 * Created by Sijmen on 10-2-2017.
 */
public abstract class Sorter {

    public static void main(String[] args) {
        int[] array = new int[]{1,9,5,3,7,6,4,8,2,7,1,2,5,8,9,6,4,7,1,5,2,3,5,9,4,7,8,5,2,1,6,4,7,8,9,9,3,2,5,7,5};

        Sorter sorter = new QuickSort();
        array = sorter.sort(array);

        System.out.println(Arrays.toString(array));
        System.out.println("rotates: " + rotateCounter);
        System.out.println("compares: " + compareCounter);
    }

    public abstract int[] sort(int[] unsorted);

    protected static int rotateCounter = 0;
    protected static int compareCounter = 0;

    protected static int[] rotate(int[] array, int index1, int index2){
        rotateCounter++;
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
        return array;
    }

    protected static boolean biggerthan(int a, int b){
        compareCounter++;
        return a > b;
    }

    protected static boolean biggerequals(int a, int b){
        compareCounter++;
        return a >= b;
    }

    protected static boolean smallerthan(int a, int b){
        compareCounter++;
        return a < b;
    }
}
