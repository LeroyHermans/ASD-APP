package it.sijmen.hanasdapp.datalgos.bigoh;

/**
 * Created by Sijmen on 7-2-2017.
 */
class Fragment4 implements Fragment {
    public long run(long n) {
        long counter = 0;
        for (long i = 0; i < n; i++)
            counter++;
        for (long j = 0; j < n; j++)
            counter++;
        return counter;
    }
}
