package ch.tutteli.tsphp.common;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonErrorNode;

/**
 *
 * @author Robert Stoll <rstoll@tutteli.ch>
 *
 * Adopted from the book Language Implementation Patterns by Terence Parr
 */
public class TSPHPErrorNode extends TSPHPAst
{

    CommonErrorNode errorNode;

    public TSPHPErrorNode(TokenStream input, Token start, Token stop, RecognitionException exception) {
        super(start);
        errorNode = new CommonErrorNode(input, start, stop, exception);
    }

    @Override
    public boolean isNil() {
        return errorNode.isNil();
    }

    @Override
    public int getType() {
        return errorNode.getType();
    }

    @Override
    public String getText() {
        return errorNode.getText();
    }

    @Override
    public String toString() {
        return errorNode.toString();
    }
}