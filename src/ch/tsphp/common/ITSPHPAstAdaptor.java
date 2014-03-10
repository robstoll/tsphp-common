/*
 * This file is part of the TSPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.common;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.TreeAdaptor;

public interface ITSPHPAstAdaptor extends TreeAdaptor
{

    ITSPHPAst clone(ITSPHPAst ast);

    @Override
    ITSPHPAst create(Token token);

    @Override
    ITSPHPAst create(int tokenType, String tokenText);

    @Override
    ITSPHPAst dupNode(Object ast);

    @Override
    ITSPHPAst errorNode(TokenStream input, Token start, Token stop, RecognitionException exception);
}
