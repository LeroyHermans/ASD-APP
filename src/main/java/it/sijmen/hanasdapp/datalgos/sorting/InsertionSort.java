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
