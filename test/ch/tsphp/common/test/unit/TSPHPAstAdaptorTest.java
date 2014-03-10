/*
 * This file is part of the TSPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.common.test.unit;

import ch.tsphp.common.ITSPHPAst;
import ch.tsphp.common.ITSPHPAstAdaptor;
import ch.tsphp.common.TSPHPAst;
import ch.tsphp.common.TSPHPAstAdaptor;
import ch.tsphp.common.test.unit.testutils.CloneAstHelper;
import org.antlr.runtime.Token;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class TSPHPAstAdaptorTest
{

    @Test
    public void clone_Standard_SameAsCopyConstructor() {
        ITSPHPAst ast = CloneAstHelper.getAssertedAst();

        ITSPHPAstAdaptor astAdaptor = createAstAdaptor();
        ITSPHPAst clone = astAdaptor.clone(ast);

        CloneAstHelper.assertIsClonedAst(clone, ast);
    }

    @Test
    public void create_ViaToken_SameAsTokenConstructor() {
        Token token = mock(Token.class);

        ITSPHPAstAdaptor astAdaptor = createAstAdaptor();
        ITSPHPAst result = astAdaptor.create(token);

        assertThat(result.getToken(), is(token));
    }

    @Test
    public void create_ViaTokenTypeAndString_CreatesTokenUsesTokenConstructor(){
        int tokenType = 2;
        String tokenText = "token";

        ITSPHPAstAdaptor astAdaptor = createAstAdaptor();
        ITSPHPAst result = astAdaptor.create(tokenType, tokenText);

        assertThat(result.getToken().getType(), is(tokenType));
        assertThat(result.getToken().getText(), is(tokenText));
    }

    @Test
    public void dupNode_IsNull_ReturnNull() {
        //No arrange needed

        ITSPHPAstAdaptor astAdaptor = createAstAdaptor();
        ITSPHPAst result = astAdaptor.dupNode(null);

        assertNull(result);
    }


    @Test(expected = ClassCastException.class)
    public void dupNode_IsNotTSPHPAst_ThrowCastException() {
        //No arrange needed

        ITSPHPAstAdaptor astAdaptor = createAstAdaptor();
        astAdaptor.dupNode(new Object());

        //assert in throw expected
    }

    @Test
    public void dupNode_IsTSPHPAst_SameAsTokenConstructor() {
        Token token = mock(Token.class);
        ITSPHPAst ast = new TSPHPAst(token);

        ITSPHPAstAdaptor astAdaptor = createAstAdaptor();
        ITSPHPAst result = astAdaptor.dupNode(ast);

        assertThat(result.getToken(), is(token));
    }

    private TSPHPAstAdaptor createAstAdaptor() {
        return new TSPHPAstAdaptor();
    }
}
