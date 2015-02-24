/*
 * This file is part of the TSPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.common.symbols;

import ch.tsphp.common.IScope;
import ch.tsphp.common.ITSPHPAst;

/**
 * Adopted from the book "Language Implementation Patterns" by Terence Parr
 */
public abstract class ASymbol implements ISymbol
{

    protected final String name;
    protected ITypeSymbol type;
    protected IScope definitionScope;
    protected final ITSPHPAst definitionAst;

    protected ASymbol(ITSPHPAst theDefinitionAst, String theName) {
        name = theName;
        definitionAst = theDefinitionAst;
    }

    @Override
    public ITSPHPAst getDefinitionAst() {
        return definitionAst;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAbsoluteName() {
        return (definitionScope != null ? definitionScope.getScopeName() : "") + name;
    }

    @Override
    public IScope getDefinitionScope() {
        return definitionScope;
    }

    @Override
    public void setDefinitionScope(IScope newScope) {
        definitionScope = newScope;
    }

    @Override
    public ITypeSymbol getType() {
        return type;
    }

    @Override
    public void setType(ITypeSymbol newType) {
        type = newType;
    }

    @Override
    public String toString() {
        return getName() + (type != null ? ":" + type : "");
    }
}
