/*
 * This file is part of the TSPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TSPHP/License
 */

/*
 * This file is part of the TinsPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TINS/License
 */

package ch.tsphp.common.symbols;

import java.util.Map;

public interface IUnionTypeSymbol extends ILazyTypeSymbol
{
    Map<String, ITypeSymbol> getTypeSymbols();

    /**
     * Adds the given type to this union and indicates whether this union has changed.
     * <p/>
     * A type might not be added if it already exists in the union or if a parent type of the given type already
     * exists in the union. In this case the method returns false because it represents the same type as before.
     */
    boolean addTypeSymbol(ITypeSymbol symbol);

    /**
     * Adds all types of the given union to this union and indicates whether this union has changed.
     * <p/>
     * A type might not be added if it already exists in the union or if a parent type of the given type already
     * exists in the union.
     */
    boolean merge(IUnionTypeSymbol unionTypeSymbol);

    /**
     * Closes the union type, no further type can be added to it
     */
    void seal();
}
