package it.sijmen.hanasdapp.datalgos.symbolchecker;

import junit.framework.AssertionFailedError;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Sijmen on 4-3-2017.
 */

public class BalancedSymbolCheckerTest {

    BalancedSymbolChecker checker;
    BalancedSymbolCheckerV2 checkerv2;

    @Before
    public void makeChecker(){
       checker = new BalancedSymbolChecker();
       checkerv2 = new BalancedSymbolCheckerV2();
    }

    @Test
    public void testCheckBalancedSymbols() throws Exception {
        check("Sijmen{" +
                "leeftijd=(18)," +
                "geslacht=(man)," +
                "hobbies=[" +
                    "{naam=(programmeren)}, " +
                    "{naam=(filmskijken)}" +
                "]" +
            "}", true);
    }

    @Test
    public void testCheckBalancedSymbolsMissing() throws Exception {
        check("(ab", false);
    }

    @Test
    public void testCheckBalancedSymbolsMixedUp() throws Exception {
        check("(ab[)]", false);
    }

    @Test
    public void testCheckBalancedSymbolsWrong() throws Exception {
        check("(ab}", false);
    }

    @Test
    public void testCheckBalancedSymbolsBigText() throws Exception {
        check("Sijmen{" +
                "leeftijd=(18)," +
                "geslacht=(man)," +
                "hobbies=[" +
                "{naam=(programmeren)}, " +
                "naam=(filmskijken)}" +
                "]" +
                "}", false);
    }

    protected void check(String string, boolean expectedOkay){
        try{
            checker.checkBalancedSymbols(string);
            if(!expectedOkay)
                throw new AssertionFailedError("Expected illegalargumentexception but got ok");
        }catch (IllegalArgumentException e){
            if(expectedOkay)
                throw new AssertionFailedError("Expected ok but got illegalargumentexception");
        }
        Assert.assertEquals(expectedOkay, checkerv2.checkBalancedSymbols(string));
    }
}