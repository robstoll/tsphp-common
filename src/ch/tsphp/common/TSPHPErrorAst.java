/*
 * This file is part of the TSPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.common;

import ch.tsphp.common.exceptions.TSPHPException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonErrorNode;

/**
 * Adopted from the book "Language Implementation Patterns" by Terence Parr.
 */
public class TSPHPErrorAst extends TSPHPAst implements ITSPHPErrorAst
{
    private final CommonErrorNode errorNode;
    private final TSPHPException exception;

    public TSPHPErrorAst(TokenStream input, Token start, Token stop, RecognitionException theException) {
        super(start);
        errorNode = new CommonErrorNode(input, start, stop, theException);
        exception = new TSPHPException(theException);
    }

    @Override
    public boolean isNil() {
        return errorNode.isNil();
    }

    @Override
    public int getType() {
        return errorNode.start.getType();
    }

    @Override
    public String getText() {
        return errorNode.getText();
    }

    @Override
    public String toString() {
        return errorNode.toString();
    }

    @Override
    public TSPHPException getException() {
        return exception;
    }
}