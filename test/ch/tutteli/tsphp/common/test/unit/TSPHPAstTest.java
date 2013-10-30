package ch.tutteli.tsphp.common.test.unit;

import ch.tutteli.tsphp.common.IScope;
import ch.tutteli.tsphp.common.ISymbol;
import ch.tutteli.tsphp.common.ITSPHPAst;
import ch.tutteli.tsphp.common.ITypeSymbol;
import ch.tutteli.tsphp.common.TSPHPAst;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class TSPHPAstTest
{

    @Test
    public void isDefinedEarlierThan_SameAst_ReturnFalse(){
        ITSPHPAst ast = new TSPHPAst();

        boolean result = ast.isDefinedEarlierThan(ast);

        assertFalse(result);
    }

    //This use case should never occur, but if it should return false
    @Test
    public void isDefinedEarlierThan_SameStartIndex_ReturnFalse(){
        ITSPHPAst ast = new TSPHPAst();
        ast.setTokenStartIndex(1);
        ITSPHPAst ast2 = new TSPHPAst();
        ast2.setTokenStartIndex(1);

        boolean result = ast.isDefinedEarlierThan(ast2);

        assertFalse(result);
    }

    @Test
    public void isDefinedEarlierThan_Earlier_ReturnTrue(){
        ITSPHPAst ast = new TSPHPAst();
        ast.setTokenStartIndex(1);
        ITSPHPAst astLater = new TSPHPAst();
        astLater.setTokenStartIndex(2);

        boolean result = ast.isDefinedEarlierThan(astLater);

        assertTrue(result);
    }


    @Test
    public void isDefinedEarlierThan_Later_ReturnFalse(){
        ITSPHPAst ast = new TSPHPAst();
        ast.setTokenStartIndex(2);
        ITSPHPAst astLater = new TSPHPAst();
        astLater.setTokenStartIndex(1);

        boolean result = ast.isDefinedEarlierThan(astLater);

        assertFalse(result);
    }

    @Test
    public void copyConstructor_copyAst_TokenEtcIsCopied(){
        //cannot test all methods but the most important one
        Token token = new CommonToken(0, "test");
        final int line = 123;
        token.setLine(line);
        final int posInLine = 456;
        token.setCharPositionInLine(posInLine);
        ITSPHPAst ast = new TSPHPAst(token);
        final int tokenStartIndex = 20;
        ast.setTokenStartIndex(tokenStartIndex);

        //especially the one which are not copied by ANTLR by default
        IScope scope = mock(IScope.class);
        ast.setScope(scope);
        ISymbol symbol = mock(ISymbol.class);
        ast.setSymbol(symbol);
        ITypeSymbol evalType = mock(ITypeSymbol.class);
        ast.setEvalType(evalType);

        ITSPHPAst clone = new TSPHPAst(ast);

        assertThat(clone.getToken().getLine(), is(line));
        assertThat(clone.getToken().getCharPositionInLine(), is(posInLine));
        assertThat(clone.getTokenStartIndex(), is(tokenStartIndex));

        assertThat(clone.getScope(), is(scope));
        assertThat(clone.getSymbol(), is(symbol));
        assertThat(clone.getEvalType(), is(evalType));

        //Verify that nothing was moved (values on the cloned instance wasn't deleted)
        assertThat(ast.getToken().getLine(), is(line));
        assertThat(ast.getToken().getCharPositionInLine(), is(posInLine));
        assertThat(ast.getTokenStartIndex(), is(tokenStartIndex));

        assertThat(ast.getEvalType(), is(evalType));
        assertThat(ast.getScope(), is(scope));
        assertThat(ast.getSymbol(), is(symbol));
    }

    @Test
    public void setText_Standard_TokenTextIsSet() {
        CommonToken token = new CommonToken(1,"token");
        String newText = "newTokenText";

        ITSPHPAst ast = new TSPHPAst(token);
        ast.setText(newText);

        assertThat(token.getText(), is(newText));
        assertThat(ast.getText(), is(newText));
    }

    @Test
    public void getChildren_HasNone_ReturnNull(){
        ITSPHPAst ast = new TSPHPAst();

        List<ITSPHPAst> children = ast.getChildren();

        assertNull(children);
    }

    @Test
    public void getChildren_HasOne_ReturnListWithOne(){
        ITSPHPAst child = new TSPHPAst(new CommonToken(1,"token"));
        ITSPHPAst ast = new TSPHPAst();
        ast.addChild(child);


        List<ITSPHPAst> children = ast.getChildren();

        assertThat(children.size(), is(1));
        assertThat(children, hasItem(child));
    }

    @Test
    public void getChild_HasNone_ReturnNull(){
        ITSPHPAst ast = new TSPHPAst();

        ITSPHPAst result = ast.getChild(0);

        assertNull(result);
    }

    @Test
    public void getChild_HasOneIndex0_ReturnChild(){
        ITSPHPAst child = new TSPHPAst(new CommonToken(1,"token"));
        ITSPHPAst ast = new TSPHPAst();
        ast.addChild(child);

        ITSPHPAst result = ast.getChild(0);

        assertThat(result, is(child));
    }

    @Test
    public void getChild_HasOneIndex1_ReturnNull(){
        ITSPHPAst child = new TSPHPAst(new CommonToken(1,"token"));
        ITSPHPAst ast = new TSPHPAst();
        ast.addChild(child);

        ITSPHPAst result = ast.getChild(1);

        assertNull(result);
    }
}
