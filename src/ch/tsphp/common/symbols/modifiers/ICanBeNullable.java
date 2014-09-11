/*
 * This file is part of the TSPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.common.symbols.modifiers;

/*
 * Represents a symbol which could hold the value null.
 */
public interface ICanBeNullable
{
    /**
     * Indicates whether the type can additionally contain null next to the regular values of this type.
     */
    boolean isNullable();
}
