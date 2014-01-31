package ch.tsphp.common.test.unit.testutils;

import ch.tsphp.common.IScope;
import ch.tsphp.common.ISymbol;
import ch.tsphp.common.ITSPHPAst;
import ch.tsphp.common.ITypeSymbol;
import ch.tsphp.common.TSPHPAst;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class CloneAstHelper
{
    public static final int line = 123;
    public static final int posInLine = 456;
    public static final int tokenIndex = 2;
    public static final int tokenStartIndex = 20;
    public static final IScope scope = mock(IScope.class);
    public static final ISymbol symbol = mock(ISymbol.class);
    public static final ITypeSymbol evalType = mock(ITypeSymbol.class);

    public static ITSPHPAst getAssertedAst() {
        //cannot test all methods but the most important one
        ITSPHPAst ast = new TSPHPAst(getAssertedToken());
        ast.setTokenStartIndex(CloneAstHelper.tokenStartIndex);

        //especially the one which are not copied by ANTLR by default
        ast.setScope(CloneAstHelper.scope);
        ast.setSymbol(CloneAstHelper.symbol);
        ast.setEvalType(CloneAstHelper.evalType);

        return ast;
    }

    private static Token getAssertedToken() {
        Token token = new CommonToken(0, "test");
        token.setLine(CloneAstHelper.line);
        token.setCharPositionInLine(CloneAstHelper.posInLine);
        token.setTokenIndex(CloneAstHelper.tokenIndex);
        return token;
    }

    public static void assertIsClonedAst(ITSPHPAst clone, ITSPHPAst ast){
        assertThat(clone, not(ast));
        //verify values are set on the clone
        assertThat(clone.getScope(), is(scope));
        assertThat(clone.getSymbol(), is(symbol));
        assertThat(clone.getEvalType(), is(evalType));
        assertThat(clone.getTokenStartIndex(), is(tokenStartIndex));

        //Verify that nothing was moved (values on the cloned instance weren't deleted)
        assertThat(ast.getScope(), is(scope));
        assertThat(ast.getSymbol(), is(symbol));
        assertThat(ast.getEvalType(), is(evalType));
        assertThat(ast.getTokenStartIndex(), is(tokenStartIndex));

        assertIsClonedToken(clone.getToken(), ast.getToken());
    }

    public static void assertIsClonedToken(Token clone, Token token) {
        assertThat(clone, not(token));
        //verify values are set on the clone
        assertThat(clone.getLine(), is(line));
        assertThat(clone.getCharPositionInLine(), is(posInLine));
        assertThat(clone.getTokenIndex(), is(tokenIndex));

        //Verify that nothing was moved (values on the cloned instance weren't deleted)
        assertThat(token.getLine(), is(line));
        assertThat(token.getCharPositionInLine(), is(posInLine));
        assertThat(token.getTokenIndex(), is(tokenIndex));

    }

}
