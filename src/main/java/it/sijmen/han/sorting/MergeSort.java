package it.sijmen.han.sorting;

/**
 * Created by Sijmen on 10-2-2017.
 */
public class MergeSort<T extends Comparable<T>> extends Sorter<T> {

    boolean mulithreadedEnabled;

    @Override
    public T[] sort(T[] unsorted) {
        mergeSort(unsorted, new Range(0, unsorted.length - 1));
        return unsorted;
    }

    @Override
    public String getName() {
        return "MergeSort";
    }

    /**
     * Mergesort a subset of a given array
     * @param array the array that contains the subset that needs to be sorted.
     *              This array is also the target array!
     * @param range The range of the array that needs to be sorted.
     */
    public void mergeSort(final T[] array, Range range) {
        if(range.length <= 1)
            return; // only 1 element in the subset, there is nothing to sort.
        if(range.length == 2) {
            //two elements, swich if needed.
            //only swich if the first element is bigger than the last
            if(array[range.start].compareTo(array[range.end]) > 0)
                rotate(array, range.start, range.end);
            return;
        }

        final Range rangeL = new Range(range.start, range.start + range.length / 2);
        final Range rangeR = new Range(range.start + range.length / 2 + 1 , range.end);

        if(mulithreadedEnabled && range.length > 1000){
            // if we are dealing with big numers than multithread this thing.
            Thread threadL = new Thread(() -> {
                mergeSort(array, rangeL);
            });
            Thread threadR = new Thread(() -> {
                mergeSort(array, rangeR);
            });
            threadL.start();
            threadR.start();
            try {
                threadL.join();
                threadR.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            // to make sure we are not making too many threads,
            // do not mulithread if the lenght is smaller than 1000
            mergeSort(array, rangeL);
            mergeSort(array, rangeR);
        }


        merge(array, rangeL, rangeR);
    }

    /**
     * Merges two ranges in a array to a single sorted range
     * @param target The array to operate on
     * @param rangeL The left range. This range must be sorted
     * @param rangeR The right range. This range must be sorted and start exacly after rangeL.
     */
    public void merge(T[] target, Range rangeL, Range rangeR){
        Object[] arrOut = new Object[rangeL.length + rangeR.length];

        int li = 0, ri = 0;

        for(int i = 0; i < arrOut.length; i++){
            if(li >= rangeL.length){ // als L leeg is, pak van R
                arrOut[i] = target[rangeR.start + ri];
                ri++;
            }
            else if(ri >= rangeR.length){ // als R leeg is, pak van L
                arrOut[i] = target[rangeL.start + li];
                li++;
            }
            else if(target[rangeL.start + li].compareTo(target[rangeR.start + ri]) <= 0) { //pak van de laagste: L
                arrOut[i] = target[rangeL.start + li];
                li++;
            }
            else{ //pak van de laagste: 2
                arrOut[i] = target[rangeR.start + ri];
                ri++;
            }
        }

        for (int i = 0; i < arrOut.length; i++)
            target[rangeL.start+i] = (T) arrOut[i];
    }

    class Range {
        int start;
        int end; // end is the last element!
        int length;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
            this.length = end-start+1;
        }

        @Override
        public String toString() {
            return "Range{" +
                    "start=" + start +
                    ", end=" + end +
                    ", length=" + length +
                    '}';
        }
    }


}
