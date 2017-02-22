package it.sijmen.han.recursive;

/**
 * Created by Sijmen on 8-2-2017.
 */
public class RecursiveTest {

    public static void main(String[] args) {
        long start1 = System.nanoTime();
        getFibonatchiAtIndex(1000);
        long stop1 = System.nanoTime();
        long start2 = System.nanoTime();
        fib(1000);
        long stop2 = System.nanoTime();

        System.out.println("time recursive: " + (stop1-start1));
        System.out.println("time looping: " + (stop2-start2));
    }

    public static long getFibonatchiAtIndex(int index) {
        if (index <= 1)
            return index;
        else
            return getFibonatchiAtIndex(index-1) + getFibonatchiAtIndex(index-2);
    }

    static int fib(int n){
        if (n<=1){
            return n;
        }

        int prevprev = 0;
        int prev = 1;
        int result = 0;

        for (int i=2;i<=n;i++){
            result = prev + prevprev;
            prevprev = prev;
            prev = result;
        }

        return result;
    }


}
