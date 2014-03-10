/*
 * This file is part of the TSPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.common.test.unit;

import ch.tsphp.common.ASymbol;
import ch.tsphp.common.IScope;
import ch.tsphp.common.ISymbol;
import ch.tsphp.common.ITSPHPAst;
import ch.tsphp.common.ITypeSymbol;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ASymbolTest
{
    private class DummySymbol extends ASymbol
    {
        protected DummySymbol(ITSPHPAst theDefinitionAst, String theName) {
            super(theDefinitionAst, theName);
        }
    }

    @Test
    public void getDefinitionAst_Standard_ReturnAst(){
        ITSPHPAst ast = mock(ITSPHPAst.class);

        ISymbol symbol = createSymbol(ast, "name");
        ITSPHPAst result = symbol.getDefinitionAst();

        assertThat(result, is(ast));
    }

    @Test
    public void getName_Standard_ReturnName(){
        ITSPHPAst ast = mock(ITSPHPAst.class);

        ISymbol symbol = createSymbol(ast, "name");
        String result = symbol.getName();

        assertThat(result, is("name"));
    }

    @Test
    public void getDefinitionScope_NothingDefined_ReturnNull(){
        //no arrange needed

        ISymbol symbol = createSymbol(mock(ITSPHPAst.class), "name");
        IScope result = symbol.getDefinitionScope();

        assertNull(result);
    }

    @Test
    public void setAndGetDefinitionScope_Standard_ReturnSetScope(){
        IScope scope = mock(IScope.class);

        ISymbol symbol = createSymbol(mock(ITSPHPAst.class), "name");
        symbol.setDefinitionScope(scope);
        IScope result = symbol.getDefinitionScope();

        assertThat(result, is(scope));
    }

    @Test
    public void set2AndGetDefinitionScope_Standard_ReturnSecondSetScope(){
        IScope scope = mock(IScope.class);
        IScope scope2 = mock(IScope.class);

        ISymbol symbol = createSymbol(mock(ITSPHPAst.class), "name");
        symbol.setDefinitionScope(scope);
        symbol.setDefinitionScope(scope2);
        IScope result = symbol.getDefinitionScope();

        assertThat(result, is(scope2));
    }

    @Test
    public void getType_NothingDefined_ReturnNull(){
        //no arrange needed

        ISymbol symbol = createSymbol(mock(ITSPHPAst.class), "name");
        ITypeSymbol result = symbol.getType();

        assertNull(result);
    }

    @Test
    public void setAndGetType_NothingDefined_ReturnSetType(){
        ITypeSymbol typeSymbol = mock(ITypeSymbol.class);

        ISymbol symbol = createSymbol(mock(ITSPHPAst.class), "name");
        symbol.setType(typeSymbol);
        ITypeSymbol result = symbol.getType();

        assertThat(result, is(typeSymbol));
    }

    @Test
    public void set2AndGetType_NothingDefined_ReturnSecondSetType(){
        ITypeSymbol typeSymbol = mock(ITypeSymbol.class);
        ITypeSymbol typeSymbol2 = mock(ITypeSymbol.class);

        ISymbol symbol = createSymbol(mock(ITSPHPAst.class), "name");
        symbol.setType(typeSymbol);
        symbol.setType(typeSymbol2);
        ITypeSymbol result = symbol.getType();

        assertThat(result, is(typeSymbol2));
    }

    @Test
    public void toString_TypeNotSet_ReturnName(){
        //no arrange needed

        ISymbol symbol = createSymbol(mock(ITSPHPAst.class), "name");
        String str = symbol.toString();

        assertThat(str, is("name"));
    }

    @Test
    public void toString_TypeSet_ReturnNameAndType(){
        ITypeSymbol type = mock(ITypeSymbol.class);
        when(type.toString()).thenReturn("type");

        ISymbol symbol = createSymbol(mock(ITSPHPAst.class), "name");
        symbol.setType(type);
        String str = symbol.toString();

        assertThat(str, is("name:type"));
    }

    private ISymbol createSymbol(ITSPHPAst ast, String name) {
        return new DummySymbol(ast,name);
    }
}
