/*
 * MIT License
 *
 * Copyright (c) 2017 Sijmen Huizenga
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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
