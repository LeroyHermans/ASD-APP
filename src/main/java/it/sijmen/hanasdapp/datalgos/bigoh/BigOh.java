/*
 * MIT License
 *
 * Copyright (c) 2017 Sijmen Huizenga
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package it.sijmen.hanasdapp.datalgos.bigoh;

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
