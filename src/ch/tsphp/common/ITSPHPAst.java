/*
 * This file is part of the TSPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.common;

import ch.tsphp.common.symbols.ISymbol;
import ch.tsphp.common.symbols.ITypeSymbol;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.Tree;

import java.util.List;

public interface ITSPHPAst extends Tree
{

    ISymbol getSymbol();

    void setSymbol(ISymbol newSymbol);

    IScope getScope();

    void setScope(IScope newScope);

    ITypeSymbol getEvalType();

    void setEvalType(ITypeSymbol newEvalType);

    boolean isDefinedEarlierThan(ITSPHPAst ast);

    void setText(String text);

    // Not defined in Tree but used through CommonTree 
    Token getToken();

    List<ITSPHPAst> getChildren();

    @Override
    ITSPHPAst getChild(int index);
}
