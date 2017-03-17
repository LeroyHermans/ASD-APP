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

package it.sijmen.hanasdapp.lang.config;

import it.sijmen.hanasdapp.lang.config.g4.ConfigurationBaseListener;
import it.sijmen.hanasdapp.lang.config.g4.ConfigurationLexer;
import it.sijmen.hanasdapp.lang.config.g4.ConfigurationParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Sijmen on 17-3-2017.
 */
public class Config extends ConfigurationBaseListener {

    HashMap<String, Object> props = new HashMap<>();

    public void loadFromResource(String resourceName) throws IOException {
        ANTLRInputStream input = new ANTLRInputStream(
                this.getClass().getClassLoader().getResourceAsStream(resourceName)
        );
        load(input);
    }

    protected void load(ANTLRInputStream input){
        ConfigurationLexer lexer = new ConfigurationLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ConfigurationParser parser = new ConfigurationParser(tokens);
        walkParser(parser);
    }

    protected void walkParser(ConfigurationParser parser){
        ParseTree tree = parser.properties();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(this, tree);
    }

    @Override
    public void exitProperty(ConfigurationParser.PropertyContext ctx) {
        ParseTree value = ctx.getChild(2);
        if(value instanceof ConfigurationParser.StringvalueContext){
            props.put(ctx.getChild(0).getText(), parseStringValue(value));
        }else if(value instanceof ConfigurationParser.IntvalueContext){
            props.put(ctx.getChild(0).getText(), parseIntValue(value));
        }
    }

    private String parseStringValue(ParseTree value) {
        String s = value.getText();
        return s.substring(1, s.length()-1);
    }

    public int parseIntValue(ParseTree value){
        return Integer.parseInt(value.getText());
    }

    @Override
    public String toString() {
        return props.toString();
    }

    public HashMap<String, Object> getProps() {
        return props;
    }
}
