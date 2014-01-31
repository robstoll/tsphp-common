package ch.tsphp.common;

public interface ISymbol
{

    ITSPHPAst getDefinitionAst();

    String getName();

    IScope getDefinitionScope();

    void setDefinitionScope(IScope definitionScope);

    ITypeSymbol getType();

    void setType(ITypeSymbol newType);
}
