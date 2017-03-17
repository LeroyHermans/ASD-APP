package it.sijmen.hanasdapp.datalgos.bigoh;

/**
 * Created by Sijmen on 7-2-2017.
 */
class Fragment1 implements Fragment {
    public long run(long n) {
        long counter = 0;
        for (long i = 0; i < n; i++)
            counter++;
        return counter;
    }
}
