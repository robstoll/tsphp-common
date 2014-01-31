package ch.tsphp.common;

import java.util.Set;

public interface ITypeSymbol extends ISymbol
{

    Set<ITypeSymbol> getParentTypeSymbols();

    boolean isNullable();
    
    /**
     * Return the default value as ITSPHPAst, as an expression respectively.
     */
    ITSPHPAst getDefaultValue();
}
