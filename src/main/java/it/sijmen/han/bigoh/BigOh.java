package it.sijmen.han.bigoh;

public class BigOh {

    public static void main(String[] args) {

        Fragment[] fragments = new Fragment[]{
                new Fragment1(),
                new Fragment2(),
                new Fragment3(),
                new Fragment4(),
                new Fragment5(),
                new Fragment6(),
                new Fragment7(),
                new Fragment8(),
        };

        long[] ns = new long[]{
                2,
                4,
                8,
                16,
                32,
                64,
                128,
                256
        };

        for(long n : ns){
            for(Fragment fragment : fragments) {
                long startNano = System.nanoTime();
                long runs = fragment.run(n);
                long stopNano = System.nanoTime();
                System.out.println(n + "," + fragment.getClass().getSimpleName() + "," + runs + "," + (stopNano - startNano));
            }
        }
    }
}
