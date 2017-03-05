package it.sijmen.han.trees;

import it.sijmen.han.lists.SArrayList;

import java.util.Arrays;

/**
 * Created by Sijmen on 5-3-2017.
 */
public class STree<T> {

    protected T value = null;

    SArrayList<STree<T>> nodes = null;

    public STree(T value){
        this.value = value;
    }

    /**
     * Adds a leaf to the tree. Returns the leaf.
     */
    public STree<T> addNode(T leafValvue){
        if(this.nodes == null)
            this.nodes = new SArrayList<>();
        STree<T> leaf = new STree<>(leafValvue);
        this.nodes.add(leaf);
        return leaf;
    }

    /**
     * Removes a node
     */
    public STree<T> removeNode(STree<T> node){
        return this.nodes.getAndRemove(node);
    }

    public boolean isEmpty(){
        return this.nodes == null && this.value == null;
    }

    public boolean hasNodes(){
        return this.nodes != null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public SArrayList<STree<T>> getNodes() {
        return nodes;
    }

    public void setNodes(SArrayList<STree<T>> nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        ToStringStatus stringStatus = new ToStringStatus();
        toString(0, stringStatus);
        return stringStatus.toString();
    }

    //iopt = input/output
    public void toString(int curLevel, ToStringStatus iopt){
        StringBuilder valueLine = iopt.line(curLevel);

        String valueString = value.toString();
        if(valueString.length() > 3)
            valueString = iopt.addReference(value);

        if(nodes == null) {
            valueLine.append("  ").append(valueString);
            return;
        }

        StringBuilder arrowLine = iopt.line(curLevel+1);
        StringBuilder elementLine = iopt.line(curLevel+2);

        elementLine.append(getSpaces(valueLine.length() - elementLine.length()));
        int elementLineLenghStart = elementLine.length();

        for(STree node : nodes)
            node.toString(curLevel+2, iopt);

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

        if(nodes.size() > 1)
            arrowLine.append(getSpaces(elementLineLenghStart - arrowLine.length()))
                    .append('/');
        if(nodes.size() == 1 || nodes.size() > 2)
            arrowLine.append(getSpaces(valueCenter - arrowLine.length()))
                            .append('|');
        if(nodes.size() > 1)
            arrowLine.append(getSpaces(elementLineLenghtEnd - arrowLine.length()))
                        .append('\\');
    }

    private static String getSpaces(int amount){
        if(amount < 1)
            return "";
        char[] chars = new char[amount];
        Arrays.fill(chars, ' ');
        return new String(chars);
    }

    class ToStringStatus {

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
