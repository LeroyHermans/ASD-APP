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

package it.sijmen.hanasdapp.datalgos.trees.algos;

import it.sijmen.hanasdapp.datalgos.lists.SArrayList;
import it.sijmen.hanasdapp.datalgos.trees.AbstractTree;

import java.util.Arrays;

/**
 * Created by Sijmen on 6-3-2017.
 */
public class ToStringAlgo<T> implements TreeAlgorithm<T, String> {

    @Override
    public String apply(AbstractTree<T> tree) {
        ToStringStatus stringStatus = new ToStringStatus();
        treeToString(tree, 0, stringStatus);
        return stringStatus.toString();
    }

    //iopt = input/output
    protected void treeToString(AbstractTree<T> tree, int curLevel, ToStringStatus iopt){
        StringBuilder valueLine = iopt.line(curLevel);

        T value = tree.getValue();

        String valueString = value == null ? "null" : value.toString();
        if(valueString.length() > 3)
            valueString = iopt.addReference(valueString);

        AbstractTree<T>[] nodes = tree.getNodes();

        if(nodes == null || nodes.length == 0) {
            valueLine.append("  ").append(valueString);
            return;
        }

        StringBuilder arrowLine = iopt.line(curLevel+1);
        StringBuilder elementLine = iopt.line(curLevel+2);

        elementLine.append(getSpaces(valueLine.length() - elementLine.length()));
        int elementLineLenghStart = elementLine.length();

        for(AbstractTree<T> node : nodes)
            treeToString(node, curLevel + 2, iopt);

        int elementLineLenghtEnd = elementLine.length();

        //to compensate for the 2 spaces, remove 2 on both sides
        elementLineLenghStart += 4;
        elementLineLenghtEnd -= 2;

        int elementsWidht = elementLineLenghtEnd - elementLineLenghStart;
        int elementsCenter = elementLineLenghStart + (elementsWidht/2);

        int valueCenter = elementsCenter;

        if(valueLine.length() >= valueCenter)
            valueCenter = valueLine.length() + 2;

        valueLine.append(getSpaces(valueCenter - valueLine.length() - 2))
                .append("  ").append(valueString);

        if(nodes.length > 1)
            arrowLine.append(getSpaces(elementLineLenghStart - arrowLine.length()))
                    .append('/');
        if(nodes.length == 1 || nodes.length > 2)
            arrowLine.append(getSpaces(valueCenter - arrowLine.length()))
                    .append('|');
        if(nodes.length > 1)
            arrowLine.append(getSpaces(elementLineLenghtEnd - arrowLine.length()))
                    .append('\\');
    }

    protected static String getSpaces(int amount){
        if(amount < 1)
            return "";
        char[] chars = new char[amount];
        Arrays.fill(chars, ' ');
        return new String(chars);
    }

    protected class ToStringStatus {

        // line 0 is the top line
        SArrayList<StringBuilder> lines = new SArrayList<>();

        SArrayList<String> references = new SArrayList<>();
        int referenceCounter = 0;

        public StringBuilder line(int linenr){
            if(linenr > lines.size())
                throw new IllegalArgumentException();
            if(linenr == lines.size()) {
                StringBuilder newLine = new StringBuilder();
                lines.add(newLine);
                return newLine;
            }
            return lines.get(linenr);
        }

        @Override
        public String toString(){
            StringBuilder out = new StringBuilder();
            for(int i = 0; i < lines.length(); i++)
                out.append(lines.get(i)).append(System.lineSeparator());
            if(references.size() > 0)
                out.append("References:").append(System.lineSeparator());
            for(String reference  : references)
                out.append(reference).append(System.lineSeparator());
            return out.toString();
        }

        public String addReference(String value) {
            referenceCounter++;
            references.add("[" + referenceCounter + "] = " + value);
            return "[" + referenceCounter + "]";
        }
    }

}
