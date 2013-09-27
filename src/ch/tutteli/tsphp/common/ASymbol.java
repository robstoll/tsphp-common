package ch.tutteli.tsphp.common;

/**
 *
 * @author Robert Stoll <rstoll@tutteli.ch>
 *
 * Adopted from the book Language Implementation Patterns by Terence Parr
 */
public abstract class ASymbol implements ISymbol
{

    protected String name;
    protected ITypeSymbol type;
    protected IScope definitionScope;
    protected ITSPHPAst definitionAst;

    protected ASymbol(ITSPHPAst theDefinitionAst, String theName) {
        name = theName;
        definitionAst = theDefinitionAst;
    }

    @Override
    public ITSPHPAst getDefinitionAst() {
        return definitionAst;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public IScope getDefinitionScope() {
        return definitionScope;
    }

    @Override
    public void setDefinitionScope(IScope newScope) {
        definitionScope = newScope;
    }

    @Override
    public ITypeSymbol getType() {
        return type;
    }

    @Override
    public void setType(ITypeSymbol newType) {
        type = newType;
    }

    @Override
    public String toString() {
        return getName() + (type != null ? ":" + type : "");
    }
}
