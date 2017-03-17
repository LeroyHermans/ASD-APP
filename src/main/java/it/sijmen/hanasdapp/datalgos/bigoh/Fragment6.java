package it.sijmen.hanasdapp.datalgos.bigoh;

/**
 * Created by Sijmen on 7-2-2017.
 */
class Fragment6 implements Fragment {
    public long run(long n) {
        long counter = 0;
        for (long i = 0; i < n; i++)
            for (long j = 0; j < i; j++)
                counter++;
        return counter;
    }
}
