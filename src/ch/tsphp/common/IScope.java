/*
 * This file is part of the TSPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.common;

import ch.tsphp.common.symbols.ISymbol;
import ch.tsphp.common.symbols.IUnionTypeSymbol;

import java.util.List;
import java.util.Map;

/**
 * Represents a scope in code.
 * <p/>
 * Adopted from the book Language Implementation Patterns by Terence Parr.
 */
public interface IScope
{

    String getScopeName();

    /**
     * Return the scope in which this scope is defined.
     * <p/>
     * Returns null for global scope.
     */
    IScope getEnclosingScope();

    /**
     * Define a symbol in the current scope.
     */
    void define(ISymbol symbol);

    /**
     * Check if everything is fine with the given symbol - no double declarations.
     */
    boolean doubleDefinitionCheck(ISymbol symbol);

    /**
     * Look up a name in this scope and return the corresponding symbol or null in the case where it cannot be found.
     */
    ISymbol resolve(ITSPHPAst typeAst);

    /**
     * Return the symbols which have been defined in this scope.
     */
    Map<String, List<ISymbol>> getSymbols();

    /**
     * Add the given symbol to the map of initialised symbols in which the flag isFullyInitialised indicates whether
     * the symbol was initialised in all branches or not.
     * <p/>
     * If the given symbol was already added to the map and the flag isFullyInitialised for the corresponding symbol
     * was already true, then nothing changes (regardless of the given flag).
     */
    void addToInitialisedSymbols(ISymbol symbol, boolean isFullyInitialised);

    /**
     * Return a map with the initialised symbols where the value indicates if it is fully initialised or just in some
     * branches.
     */
    Map<String, Boolean> getInitialisedSymbols();

    /**
     * Indicates whether the given symbol is fully initialised or not.
     * <p/>
     * If a symbol is partially initialised (or not at all) at the point where this method is called then it will
     * return false.
     */
    boolean isFullyInitialised(ISymbol symbol);

    /**
     * Indicates whether the given symbol is partially initialised or not.
     * <p/>
     * If a symbol is fully initialised (or not at all) at the point where this method is called then it will return
     * false
     */
    boolean isPartiallyInitialised(ISymbol symbol);

    Map<String, List<IConstraint>> getConstraints();

    List<IConstraint> getConstraintsForVariable(String variableId);

    void addConstraint(String variableId, IConstraint constraint);

    IUnionTypeSymbol getResultOfConstraintSolving(String variableId);

    void setResultOfConstraintSolving(String variableId, IUnionTypeSymbol typeSymbol);
}
