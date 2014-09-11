/*
 * This file is part of the TSPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.common.symbols;


import ch.tsphp.common.symbols.modifiers.IModifierSet;

public interface ISymbolWithModifier extends ISymbol
{

    void addModifier(Integer modifier);

    boolean removeModifier(Integer modifier);

    IModifierSet getModifiers();

    void setModifiers(IModifierSet modifier);
}
