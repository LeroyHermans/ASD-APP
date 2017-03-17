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