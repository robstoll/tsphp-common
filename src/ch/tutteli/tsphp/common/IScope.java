/*
 * Copyright 2013 Robert Stoll <rstoll@tutteli.ch>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
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
