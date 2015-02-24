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

    void addTypeSymbol(ITypeSymbol symbol);

    void merge(IUnionTypeSymbol unionTypeSymbol);

    /**
     * Closes the union type, no further type can be added to it
     */
    void seal();
}
