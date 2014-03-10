/*
 * This file is part of the TSPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.common.test.unit;

import ch.tsphp.common.ITSPHPAst;
import ch.tsphp.common.TSPHPAst;
import ch.tsphp.common.test.unit.testutils.CloneAstHelper;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class TSPHPAstTest
{

    @Test
    public void isDefinedEarlierThan_SameAst_ReturnFalse() {
        ITSPHPAst ast = new TSPHPAst();

        boolean result = ast.isDefinedEarlierThan(ast);

        assertFalse(result);
    }

    //This use case should never occur, but if it should return false
    @Test
    public void isDefinedEarlierThan_SameStartIndex_ReturnFalse() {
        ITSPHPAst ast = new TSPHPAst();
        ast.setTokenStartIndex(1);
        ITSPHPAst ast2 = new TSPHPAst();
        ast2.setTokenStartIndex(1);

        boolean result = ast.isDefinedEarlierThan(ast2);

        assertFalse(result);
    }

    @Test
    public void isDefinedEarlierThan_Earlier_ReturnTrue() {
        ITSPHPAst ast = new TSPHPAst();
        ast.setTokenStartIndex(1);
        ITSPHPAst astLater = new TSPHPAst();
        astLater.setTokenStartIndex(2);

        boolean result = ast.isDefinedEarlierThan(astLater);

        assertTrue(result);
    }


    @Test
    public void isDefinedEarlierThan_Later_ReturnFalse() {
        ITSPHPAst ast = new TSPHPAst();
        ast.setTokenStartIndex(2);
        ITSPHPAst astLater = new TSPHPAst();
        astLater.setTokenStartIndex(1);

        boolean result = ast.isDefinedEarlierThan(astLater);

        assertFalse(result);
    }

    @Test
    public void copyConstructor_copyAst_TokenEtcIsCopied() {
        ITSPHPAst ast = CloneAstHelper.getAssertedAst();

        ITSPHPAst clone = new TSPHPAst(ast);

        CloneAstHelper.assertIsClonedAst(clone, ast);
    }

    @Test
    public void tokenConstructor_Standard_IsSameToken(){
        Token token = mock(Token.class);

        ITSPHPAst clone = new TSPHPAst(token);

        assertThat(clone.getToken(), is(token));
    }

    @Test
    public void setText_Standard_TokenTextIsSet() {
        CommonToken token = new CommonToken(1, "token");
        String newText = "newTokenText";

        ITSPHPAst ast = new TSPHPAst(token);
        ast.setText(newText);

        assertThat(token.getText(), is(newText));
        assertThat(ast.getText(), is(newText));
    }

    @Test
    public void getChildren_HasNone_ReturnNull() {
        ITSPHPAst ast = new TSPHPAst();

        List<ITSPHPAst> children = ast.getChildren();

        assertNull(children);
    }

    @Test
    public void getChildren_HasOne_ReturnListWithOne() {
        ITSPHPAst child = new TSPHPAst(new CommonToken(1, "token"));
        ITSPHPAst ast = new TSPHPAst();
        ast.addChild(child);


        List<ITSPHPAst> children = ast.getChildren();

        assertThat(children.size(), is(1));
        assertThat(children, hasItem(child));
    }

    @Test
    public void getChild_HasNone_ReturnNull() {
        ITSPHPAst ast = new TSPHPAst();

        ITSPHPAst result = ast.getChild(0);

        assertNull(result);
    }

    @Test
    public void getChild_HasOneIndex0_ReturnChild() {
        ITSPHPAst child = new TSPHPAst(new CommonToken(1, "token"));
        ITSPHPAst ast = new TSPHPAst();
        ast.addChild(child);

        ITSPHPAst result = ast.getChild(0);

        assertThat(result, is(child));
    }

    @Test
    public void getChild_HasOneIndex1_ReturnNull() {
        ITSPHPAst child = new TSPHPAst(new CommonToken(1, "token"));
        ITSPHPAst ast = new TSPHPAst();
        ast.addChild(child);

        ITSPHPAst result = ast.getChild(1);

        assertNull(result);
    }
}
