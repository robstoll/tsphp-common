package ch.tsphp.common;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTreeAdaptor;

/**
 * Adaptor used to create the correct type of {@link ITSPHPAst}.
 *
 * Adopted from the book "Language Implementation Patterns" by Terence Parr
 */
public class TSPHPAstAdaptor extends CommonTreeAdaptor implements ITSPHPAstAdaptor
{

    @Override
    public ITSPHPAst clone(ITSPHPAst ast) {
        return new TSPHPAst(ast);
    }

    @Override
    public ITSPHPAst create(Token token) {
        return new TSPHPAst(token);
    }

    @Override
    public ITSPHPAst create(int tokenType, String text) {
        return new TSPHPAst(super.createToken(tokenType, text));
    }

    @Override
    public ITSPHPAst dupNode(Object ast) {
        if (ast == null) {
            return null;
        }
        return create(((TSPHPAst) ast).token);
    }

    @Override
    public ITSPHPAst errorNode(TokenStream input, Token start, Token stop, RecognitionException exception) {
        return new TSPHPErrorAst(input, start, stop, exception);
    }
}
