package ch.tutteli.tsphp.common.test.unit;

import ch.tutteli.tsphp.common.ITSPHPAst;
import ch.tutteli.tsphp.common.ITSPHPAstAdaptor;
import ch.tutteli.tsphp.common.TSPHPAst;
import ch.tutteli.tsphp.common.TSPHPAstAdaptor;
import ch.tutteli.tsphp.common.test.unit.testutils.CloneAstHelper;
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
    public void create_Standard_SameAsTokenConstructor() {
        Token token = mock(Token.class);

        ITSPHPAstAdaptor astAdaptor = createAstAdaptor();
        ITSPHPAst result = astAdaptor.create(token);

        assertThat(result.getToken(), is(token));
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
