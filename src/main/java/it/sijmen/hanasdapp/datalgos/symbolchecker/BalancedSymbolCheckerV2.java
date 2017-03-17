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
