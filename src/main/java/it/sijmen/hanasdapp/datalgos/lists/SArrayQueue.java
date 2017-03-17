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

package it.sijmen.hanasdapp.datalgos.lists;

/**
 * Sijmens Super Queue
 * #untested
 * Created by Sijmen on 4-3-2017.
 */
public class SArrayQueue<T> {

    private SArrayList<T> list = new SArrayList<>();

    /**
     * Toevoegen aan het einde, teruggegeven of hij vol is.
     */
    public boolean insert(T item){
        if(isFull())
            return false;
        list.add(item);
        return true;
    }

    /**
     * eerste verwijderen uit lijst en teruggeven
     */
    public T remove(){
        if(isEmpty())
            return null;
        return list.removeAt(0);
    }

    /**
     * eerste teruggeven, NIET verwijderen uit lijst
     */
    public T peek(){
        if(isEmpty())
            return null;
        return list.get(0);
    }

    /**
     * Is hij leeg?
     */
    public boolean isEmpty(){
        return list.length() == 0;
    }

    /**
     * Is hij vol?
     */
    boolean isFull(){
        return list.length() == Integer.MIN_VALUE;
    }

    @Override
    public String toString() {
        return "SArrayQueue{" +
                "list=" + list.arrayToString() +
                ", length=" + list.length() +
                '}';
    }
}
