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

package it.sijmen.hanasdapp.datalgos.toets1.opgave2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Sijmen on 15-3-2017.
 */
public class RegexGraph {

    private String title;
    private boolean isFinishedPoint;

    private HashMap<Character, RegexGraph> nextNodes = new HashMap<>();

    public RegexGraph(String title, boolean isFinishedPoint) {
        this.isFinishedPoint = isFinishedPoint;
        this.title = title;
    }

    public void addNextNode(Character textToNode, RegexGraph nextNode) {
        nextNodes.put(textToNode, nextNode);
    }

    @Override
    public String toString() {
        return new RegexGraphStringifyer().getText();
    }

    public boolean matches(String input){
        if(input == null || input.length() == 0)
            return this.isFinishedPoint;
        char firstStringChar = input.charAt(0);
        for(char nodeChar : nextNodes.keySet()){
            if(firstStringChar == nodeChar)
                return nextNodes.get(nodeChar).matches(input.substring(1));
        }
        return false;
    }

    class RegexGraphStringifyer {

        ArrayList<RegexGraph> visitedNodes = new ArrayList<>();

        StringBuilder builder = new StringBuilder();

        public String getText() {
            getNodeText(RegexGraph.this, "");
            return builder.toString();
        }

        protected void getNodeText(RegexGraph graph, String padding){
            visitedNodes.add(graph);
            builder.append(padding)
                    .append(graph.title)
                    .append("(finished=")
                    .append(graph.isFinishedPoint)
                    .append(")");

            if(!graph.nextNodes.isEmpty()){
                builder.append("goes to: [\n");

                for(Character nextPath : graph.nextNodes.keySet()){
                    RegexGraph nextNode = graph.nextNodes.get(nextPath);
                    if(nextNode == null)
                        continue;

                    builder.append(padding)
                            .append("\t")
                            .append(nextNode.title)
                            .append(" via '")
                            .append(nextPath)
                            .append("'\n");

                    if(visitedNodes.contains(nextNode))
                        continue;
                    getNodeText(nextNode, padding + "\t\t");
                }
                builder.append(padding).append("]");
            }

            builder.append("\n");
        }
    }
}
