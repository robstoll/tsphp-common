/*
 * This file is part of the TSPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.common.symbols;

import ch.tsphp.common.IScope;
import ch.tsphp.common.ITSPHPAst;

public interface ISymbol
{

    ITSPHPAst getDefinitionAst();

    String getName();

    /**
     * Returns the absolute name of this symbol which might well include the namespace name.
     * <p/>
     * The important part is that the name which is returned by this method can be used at any point to refer to this
     * symbol without ambiguity. For instance, a type will include most of the time the namespace name in which it
     * was defined. Hence, it can be used as type of a variable, parameter etc. and does not conflict with another
     * type in the current scope.
     * <p/>
     * For instance, it would be wrong to return "A" for the class "A" defined in the default namespace since it
     * would get
     * another meaning when this absolute name is used in another namespace than the default namespace. The same
     * applies for constants, functions etc.
     */
    String getAbsoluteName();

    IScope getDefinitionScope();

    void setDefinitionScope(IScope definitionScope);

    ITypeSymbol getType();

    void setType(ITypeSymbol newType);
}
