package it.sijmen.han.sorting;

import java.util.Arrays;

/**
 * Created by Sijmen on 11-2-2017.
 */
public class QuicksortInternet extends Sorter{

    private int[] numbers;
    private int number;

    @Override
    public int[] sort(int[] unsorted) {
        // check for empty or null array
        if (unsorted ==null || unsorted.length==0){
            return unsorted;
        }
        this.numbers = unsorted;
        number = unsorted.length;
        quicksort(0, number - 1);
        return numbers;
    }

    private void quicksort(int lowIndex, int highIndex) {
        int indexL = lowIndex, indexR = highIndex;
        // Get the pivot element from the middle of the list
        int pivot = numbers[lowIndex + (highIndex-lowIndex)/2];

        System.out.println("QUICKSORT PIVOT " + pivot);

        System.out.println(Arrays.toString(Arrays.copyOfRange(numbers, lowIndex, highIndex + 1)));
        printstatus(lowIndex, indexL, indexR);

        // Divide into two lists
        while (indexL <= indexR) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (numbers[indexL] < pivot) {
                indexL++;
                printstatus(lowIndex, indexL, indexR);
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (numbers[indexR] > pivot) {
                indexR--;
                printstatus(lowIndex, indexL, indexR);
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase indexL and indexR
            if (indexL <= indexR) {
                rotate(numbers, indexL, indexR);
                System.out.println("ROTATE");
                System.out.println(Arrays.toString(Arrays.copyOfRange(numbers, lowIndex, highIndex + 1)));
                printstatus(lowIndex, indexL, indexR);
                indexL++;
                indexR--;
                printstatus(lowIndex, indexL, indexR);
            }
        }
        // Recursion
        if (lowIndex < indexR)
            quicksort(lowIndex, indexR);
        if (indexL < highIndex)
            quicksort(indexL, highIndex);
    }

    private void printstatus(int start, int indexL, int indexR) {
        if(indexL < indexR)
            System.out.println(getSpaces(1+(indexL-start)*3)+"L"+getSpaces(-1+(indexR-indexL)*3)+"R");
        if(indexR < indexL)
            System.out.println(getSpaces(1 + (indexR - start) * 3) + "R" + getSpaces(-1 + (indexL - indexR) * 3) + "L");
        if(indexR == indexL)
            System.out.println(getSpaces(1 + (indexR - start) * 3) + "A");
    }

    private String getSpaces(int n){
        String out = "";
        while(n > 0) {
            out += " ";
            n--;
        }
        return out;
    }

}
