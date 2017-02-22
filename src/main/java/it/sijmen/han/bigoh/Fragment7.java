package it.sijmen.han.bigoh;

/**
 * Created by Sijmen on 7-2-2017.
 */
class Fragment7 implements Fragment {
    public long run(long n) {
        long counter = 0;
        for (long i = 0; i < n; i++)
            for (long j = 0; j < n * n; j++)
                for (long k = 0; k < j; k++)
                    counter++;
        return counter;
    }
}
