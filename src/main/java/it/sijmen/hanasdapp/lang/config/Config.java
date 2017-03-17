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
