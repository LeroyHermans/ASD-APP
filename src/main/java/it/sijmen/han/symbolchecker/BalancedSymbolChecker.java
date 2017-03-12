package it.sijmen.han.symbolchecker;

import it.sijmen.han.lists.SStack;

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
