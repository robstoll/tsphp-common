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
     * Returns the default value as ITSPHPAst, as an expression respectively.
     */
    ITSPHPAst getDefaultValue();

    /**
     * Returns itself or null if the type is lazy and not yet ready.
     *
     * @return
     */
    ITypeSymbol evalSelf();

    /**
     * Indicates whether this type can be used in an intersection type among other types which are not in the same
     * type hierarchy.
     * <p/>
     * Currently, only interfaces have this property. Types like num & bool do not make sense.
     */
    boolean canBeUsedInIntersection();
}
