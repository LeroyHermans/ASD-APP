package it.sijmen.han.sorting;

/**
 * Created by Sijmen on 10-2-2017.
 */
public class InsertionSortCollin extends Sorter {
    @Override
    public int[] sort(int[] numbers) {
        for(int i = 1; smallerthan(i, numbers.length); i++){
            int currentI = i;

            while(biggerequals(currentI, 1) && smallerthan(numbers[currentI], numbers[(currentI-1)])){
                rotate(numbers, currentI, currentI-1);
                currentI--;
            }
        }
        return numbers;
    }
}
