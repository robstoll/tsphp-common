/*
 * Copyright 2012 Robert Stoll <rstoll@tutteli.ch>
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

/**
 *
 * @author Robert Stoll <rstoll@tutteli.ch>
 *
 * Adopted from the book Language Implementation Patterns by Terence Parr
 */
public interface IScope
{

    public String getScopeName();

    /**
     * Where to look next for symbols; superclass or enclosing scope
     */
    public IScope getParentScope();

    /**
     * Scope in which this scope is defined. Returns null for global scope.
     */
    public IScope getEnclosingScope();

    /**
     * Define a symbol in the current scope
     */
    public void define(ASymbol sym);

    /**
     * Look up name in this scope or in parent scope if not here
     */
    public ASymbol resolve(String name);
}
