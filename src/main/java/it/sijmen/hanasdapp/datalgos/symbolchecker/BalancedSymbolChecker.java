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

/**
 * Created by Sijmen on 4-3-2017.
 */
public class BalancedSymbolChecker {

    private char[] openChars =  "({[<".toCharArray();
    private char[] closeChars = ")}]>".toCharArray();


    public void checkBalancedSymbols(String totalInputString) throws IllegalArgumentException {
        //sorry voor de veel te lange variablenamen. Ik vind het ook niet mooi, maar het is de enige
        //manier om nog een klein beetje te kunnen snappen wat er allemaal aan de hand is.
        //success ermee! ;)

        SStack<Integer> openCharStack = new SStack<>();

        char[] totalInputCharArray = totalInputString.toCharArray();
        for (int curCharIndexInTotal = 0; curCharIndexInTotal < totalInputCharArray.length; curCharIndexInTotal++) {
            char curChar = totalInputCharArray[curCharIndexInTotal];

            int curCharIndexInOpenChar = indexOf(openChars, curChar);

            if(curCharIndexInOpenChar != -1) {
                openCharStack.push(curCharIndexInTotal);
                continue;
            }

            int curCharIndexInCloseChar = indexOf(closeChars, curChar);
            if(curCharIndexInCloseChar == -1)
                continue;

            int lastOpenCharIndexInTotal = openCharStack.pop();
            char lastOpenChar = totalInputCharArray[lastOpenCharIndexInTotal];
            int lastOpenCharIndexInOpenChars = indexOf(openChars, lastOpenChar);
            if(lastOpenCharIndexInOpenChars == curCharIndexInCloseChar)
                continue;

            throw new IllegalArgumentException(
                    "In string \"" + totalInputString + "\" the symbols are not balanced.\n"+
                            "Opening character '" + lastOpenChar + "' at string index " + lastOpenCharIndexInTotal +
                            " was closed by character '" + closeChars[curCharIndexInCloseChar] + "' at index " + curCharIndexInTotal + "\n" +
                            "This is not allowed. All opening characters \"" + new String(openChars) + "\"" +
                            " should be closed by the corresponding closing character \"" + new String(closeChars) + "\""
            );
        }
        if(openCharStack.getSize() != 0)
            throw new IllegalArgumentException(
                    "End of string was reached before finding closing characters. The indexes of opening characters that" +
                            "are not closed are " + openCharStack.toString()
            );
    }

    private int indexOf(char[] arr, char c){
        for (int i = 0; i < arr.length; i++)
            if (c == arr[i])
                return i;
        return -1;
    }
}
