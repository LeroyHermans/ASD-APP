package it.sijmen.han.sorting;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import it.sijmen.han.generics.MemoryCell;
import org.hamcrest.CustomTypeSafeMatcher;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Sijmen on 22-2-2017.
 */
@RunWith(DataProviderRunner.class)
public class SorterTest {

    static Sorter[] sorters = new Sorter[]{
            new InsertionSort(),
            new MergeSort(),
            new QuickSort()
    };

    static Comparable[][] testsets = new Comparable[][]{
            //allemaal gelijk
            {1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1},
            {0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,},

            // in volgorde
            // verschillende aantallen omdat algoritmes fouten kunnen maken bij bijzondere hoeveelheden.
            {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16},
            {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15},
            {1,2,3,4,5,6,7,8,9,10,11,12,13,14},
            {1,2,3,4,5,6,7,8,9,10,11,12,13},
            {1,2,3,4,5,6,7,8,9,10,11,12},
            {1,2,3,4,5,6,7,8,9,10,11},

            // precies verkeerd om
            // verschillende aantallen omdat algoritmes fouten kunnen maken bij bijzondere hoeveelheden.
            {16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1},
            {16,15,14,13,12,11,10,9,8,7,6,5,4,3,2},
            {16,15,14,13,12,11,10,9,8,7,6,5,4,3},
            {16,15,14,13,12,11,10,9,8,7,6,5,4},
            {16,15,14,13,12,11,10,9,8,7,6,5},
            {16,15,14,13,12,11,10,9,8,7,6},

            // allemaal gelijk behalve 1
            {1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1},
            {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},

            // bijna gesorteerd, allemaal uniek
            {1,2,4,3,5,6,7,8,10,9,11,14,13,12,15,16},
            {2,1,3,4,5,6,7,8,9,10,11,12,13,14,15,16},
            {1,2,3,4,5,6,7,8,10,9,11,12,13,14,16,15},

            // weinig uniek
            {1,1,1,1,1,2,2,2,2,3,3,4,4,4,4,5,5,5,5,5,5,5,5},
            {1,5,2,3,5,4,5,4,2,1,2,4,2,5,2,2,5,2,4,1,2,5,2},
            {1,5,2,3,5,4,5,4,2,1,2,4,2,5,2,2,5,2,4,1,2,5,2},
            {3,5,2,1,5,1,4,3,3,5,3,5,2,3,1,1,4,3,4,4,5,3,2,4,2,2,4,4,3,1,1,3,2,3,2,1,5,5,5,1,1,2,1,2},

            //random sets
            {39,35,2,20,19,50,38,23,15,24,26,22,33,12,43,13,45,28,6,10},
            {10,24,1,19,29,50,31,41,16,11,20,45,3,23,39,2,12,35,6,40},
            {5,47,15,30,31,49,25,35,32,17,23,34,36,13,29,22,48,18,2,9},
            {4,21,6,11,42,46,29,9,37,13,30,22,32,36,39,45,34,5,25,18},
            {10,42,34,49,36,18,26,33,29,12,39,43,46,32,14,44,48,2,6,38},
            {8,40,33,16,1,19,28,4,50,13,32,5,21,6,3,9,44,38,25,17},
            {45,46,18,9,11,1,2,48,20,32,23,42,35,4,44,39,19,36,37,41},
            {30,41,6,14,22,25,29,20,39,21,35,43,50,18,40,2,16,1,5,26},
            {20,16,36,41,5,42,49,15,13,9,19,27,6,35,40,32,31,30,23,47},
            {40,4,14,6,11,32,38,23,41,46,1,24,45,44,16,37,33,43,21,5},
            {8,8,5,3,9,2,5,9,8,8,6,5,7,10,5,5,7,5,4,2,8,7},
            {18,25,45,10,23,19,44,49,40,14,37,12,50,34,3,25,37,12,2,28,37,4,35,1,21,20,29,37,14,5,43,23,46,28,26,19,37,15,18,14,50,22,47,17},

            //special cases
            {},
            null,

            {new MemoryCell<>("A"), new MemoryCell<>("C"), new MemoryCell<>("D"), new MemoryCell<>("Q")},

            //the last element is a 5000, auto-generated array
            new Integer[5000]
    };
    static {
        Random r = new Random();
        for (int i1 = 0; i1 < testsets[testsets.length - 1].length; i1++)
            testsets[testsets.length - 1][i1] = r.nextInt(10000);
    }

    @DataProvider
    public static Object[][] sorterDataProvider() {
        Object[][] out = new Object[sorters.length * testsets.length][2];

        for (int i = 0; i < sorters.length; i++) {
            for (int j = 0; j < testsets.length; j++) {
                out[i*testsets.length+j][0] = sorters[i];
                out[i*testsets.length+j][1] = testsets[j];
            }
        }
        return out;
    }

    @Test
    @UseDataProvider("sorterDataProvider")
    public void test(Sorter sorter, Comparable[] input) throws Exception {
        Comparable[] output = input == null ? null : input.clone();
        output = sorter.sort(output);

        if(input == null && output == null)
            return;

        assertThat(sorter.getName() + ":" + Arrays.toString(input), output, sortedArrayMatcher);
    }

    CustomTypeSafeMatcher<Comparable[]> sortedArrayMatcher =
            new CustomTypeSafeMatcher<Comparable[]>("sorted array") {
        @Override
        protected boolean matchesSafely(Comparable[] data) {
            for (int i = 0; i < data.length-1; i++)
                if(data[i].compareTo(data[i+1]) > 0)
                    return false;
            return true;
        }
    };

}//