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

/**
 * Represents a type which is lazy in the sense of the actual type is not known yet.
 */
public interface ILazyTypeSymbol extends ITypeSymbol
{
    void addForEvalReadyListener(IForEvalReadyListener typeSymbol);

    boolean isReadyForEval();
}
