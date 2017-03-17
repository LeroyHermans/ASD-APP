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

package it.sijmen.hanasdapp.datalgos.symbolchecker;

import it.sijmen.hanasdapp.datalgos.lists.SStack;
import it.sijmen.hanasdapp.datalgos.maps.SSeperateChainingHashMap;

/**
 * Created by mastermindzh on 10-3-17.
 */
public class BalancedSymbolCheckerV2 {

    SStack<Character> myStack = new SStack<>();

    SSeperateChainingHashMap<Character, Character> bracketPairs = new SSeperateChainingHashMap<Character, Character>(){
        {
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }
    };

    public boolean checkBalancedSymbols(String str) {
        for(int i = 0; i < str.length(); i++) {
            char charToBeProcessed = str.charAt(i);

            if (bracketPairs.containsKey(charToBeProcessed)) {
                myStack.push(charToBeProcessed);
            } else if (bracketPairs.containsValue(charToBeProcessed)) {
                // check whether stack has an element
                if (myStack.getSize() != 0) {
                    // check whether char on stack (key) has a value of charToBeProcessed
                    if (bracketPairs.get(myStack.pop()) != charToBeProcessed) {
                        return false;
                    }
                }
            }
        }

        return myStack.getSize() == 0;
    }

}
