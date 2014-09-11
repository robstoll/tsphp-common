/*
 * This file is part of the TSPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.common.symbols;

import ch.tsphp.common.ITSPHPAst;
import ch.tsphp.common.symbols.modifiers.ICanBeFalseable;
import ch.tsphp.common.symbols.modifiers.ICanBeNullable;

import java.util.Set;

public interface ITypeSymbol extends ISymbolWithModifier, ICanBeFalseable, ICanBeNullable
{

    Set<ITypeSymbol> getParentTypeSymbols();

    /**
     * Return the default value as ITSPHPAst, as an expression respectively.
     */
    ITSPHPAst getDefaultValue();
}
