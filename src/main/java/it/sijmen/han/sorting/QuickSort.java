package it.sijmen.han.sorting;

import java.util.Arrays;

/**
 * Created by Sijmen on 10-2-2017.
 */
public class QuickSort extends Sorter {

    @Override
    public int[] sort(int[] nums) {
        return quicksort(nums, 0, nums.length-1);
    }

    public int[] quicksort(int[] nums, int lowIndex, int highIndex){
        System.out.println("QUICKSORT");
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, lowIndex, highIndex+1)));

        int pivot = nums[lowIndex+(highIndex-lowIndex)/2];
        System.out.println("pivot: " + pivot);

        int indexL = lowIndex, indexR = highIndex;
        printstatus(lowIndex, indexL, indexR);

        while(indexL <= indexR){
            while( nums[indexL] < pivot) {
                indexL++;
                printstatus(lowIndex, indexL, indexR);
            }
            while(nums[indexR] > pivot) {
                indexR--;
                printstatus(lowIndex, indexL, indexR);
            }
            if(indexL <= indexR) {
                if(nums[indexL] != nums[indexR]){
                    System.out.println("ROTATE:");
                    printstatus(lowIndex, indexL, indexR);
                    rotate(nums, indexL, indexR);
                    System.out.println(Arrays.toString(Arrays.copyOfRange(nums, lowIndex, highIndex + 1)));
                }
                indexL++;
                indexR--;
                printstatus(lowIndex, indexL, indexR);

            }
        }

        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, lowIndex, highIndex + 1)));

        // Recursion
        if (lowIndex < indexR)
            quicksort(nums, lowIndex, indexR);
        if (indexL < highIndex)
            quicksort(nums, indexL, highIndex);

        return nums;
    }

    private void printstatus(int start, int indexL, int indexR) {
        if(indexL < indexR)
            System.out.println(getSpaces(1+(indexL-start)*3)+"L"+getSpaces(-1+(indexR-indexL)*3)+"R");
        if(indexR < indexL)
            System.out.println(getSpaces(1+(indexR-start)*3)+"R"+getSpaces(-1+(indexL-indexR)*3)+"L");
        if(indexR == indexL)
            System.out.println(getSpaces(1+(indexR-start)*3)+"A");
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
