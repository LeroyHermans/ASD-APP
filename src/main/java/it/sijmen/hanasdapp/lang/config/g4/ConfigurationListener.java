// Generated from /src/main/resources\Configuration.g4 by ANTLR 4.6
package it.sijmen.hanasdapp.lang.config.g4;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ConfigurationParser}.
 */
public interface ConfigurationListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ConfigurationParser#properties}.
	 * @param ctx the parse tree
	 */
	void enterProperties(ConfigurationParser.PropertiesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigurationParser#properties}.
	 * @param ctx the parse tree
	 */
	void exitProperties(ConfigurationParser.PropertiesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConfigurationParser#property}.
	 * @param ctx the parse tree
	 */
	void enterProperty(ConfigurationParser.PropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigurationParser#property}.
	 * @param ctx the parse tree
	 */
	void exitProperty(ConfigurationParser.PropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConfigurationParser#stringvalue}.
	 * @param ctx the parse tree
	 */
	void enterStringvalue(ConfigurationParser.StringvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigurationParser#stringvalue}.
	 * @param ctx the parse tree
	 */
	void exitStringvalue(ConfigurationParser.StringvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConfigurationParser#intvalue}.
	 * @param ctx the parse tree
	 */
	void enterIntvalue(ConfigurationParser.IntvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConfigurationParser#intvalue}.
	 * @param ctx the parse tree
	 */
	void exitIntvalue(ConfigurationParser.IntvalueContext ctx);
}