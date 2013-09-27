package ch.tutteli.tsphp.common;

import java.util.Set;

/**
 *
 * @author Robert Stoll <rstoll@tutteli.ch>
 *
 */
public interface ITypeSymbol extends ISymbol
{

    Set<ITypeSymbol> getParentTypeSymbols();

    boolean isNullable();
    
    /**
     * Return the default value as ITSPHPAst, as an expression respectively.
     */
    ITSPHPAst getDefaultValue();
}
