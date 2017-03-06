package it.sijmen.han.trees;

import it.sijmen.han.lists.SArrayList;

import java.util.Arrays;

/**
 * Created by Sijmen on 6-3-2017.
 */
public class TreeToString<T> {

    public String treeToString(AbstractTree<T> tree) {
        ToStringStatus stringStatus = new ToStringStatus();
        treeToString(tree, 0, stringStatus);
        return stringStatus.toString();
    }

    //iopt = input/output
    protected void treeToString(AbstractTree<T> tree, int curLevel, ToStringStatus iopt){
        StringBuilder valueLine = iopt.line(curLevel);

        String valueString = tree.getValue().toString();
        if(valueString.length() > 3)
            valueString = iopt.addReference(tree.getValue());

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

        public String addReference(T value) {
            referenceCounter++;
            references.add("[" + referenceCounter + "] = " + value.toString());
            return "[" + referenceCounter + "]";
        }
    }

}
