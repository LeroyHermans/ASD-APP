package it.sijmen.hanasdapp.datalgos.bigoh;

/**
 * Created by Sijmen on 7-2-2017.
 */
class Fragment8 implements Fragment {
    public long run(long n) {
        long counter = 0;
        for (long i = 1; i < n; i = i * 2)
            counter++;
        return counter;
    }
}
