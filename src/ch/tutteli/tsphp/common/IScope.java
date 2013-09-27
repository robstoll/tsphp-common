package ch.tutteli.tsphp.common;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Robert Stoll <rstoll@tutteli.ch>
 *
 * Adopted from the book Language Implementation Patterns by Terence Parr
 */
public interface IScope
{

    String getScopeName();

    /**
     * Return the scope in which this scope is defined.
     *
     * Returns null for global scope.
     */
    IScope getEnclosingScope();

    /**
     * Define a symbol in the current scope
     */
    void define(ISymbol sym);

    /**
     * Check if everything is fine with the given symbol - no double declarations.
     */
    boolean doubleDefinitionCheck(ISymbol sym);

    /**
     * Look up a name in this scope and return the corresponding symbol or null in the case where it cannot be found.
     */
    ISymbol resolve(ITSPHPAst typeAst);

    /**
     * Return the symbols which have been defined in this scope
     */
    Map<String, List<ISymbol>> getSymbols();
}
