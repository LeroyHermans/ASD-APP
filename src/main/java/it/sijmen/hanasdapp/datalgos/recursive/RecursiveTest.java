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

package it.sijmen.hanasdapp.datalgos.recursive;

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
