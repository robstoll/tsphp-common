package ch.tutteli.tsphp.common;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;

import java.util.List;

/**
 * Adopted from the book "Language Implementation Patterns" by Terence Parr
 */
public class TSPHPAst extends CommonTree implements ITSPHPAst
{

    private IScope scope;
    private ISymbol symbol;
    private ITypeSymbol evalType;

    public TSPHPAst() {
        //used to create pseudo ASTs
    }

    public TSPHPAst(ITSPHPAst ast) {
        super((CommonTree) ast);
        //CommonTree does not clone token
        token = new CommonToken(token);
        scope = ast.getScope();
        symbol = ast.getSymbol();
        evalType = ast.getEvalType();
    }

    public TSPHPAst(Token token) {
        super(token);
    }

    @Override
    public ISymbol getSymbol() {
        return symbol;
    }

    @Override
    public void setSymbol(ISymbol newSymbol) {
        symbol = newSymbol;
    }

    @Override
    public IScope getScope() {
        return scope;
    }

    @Override
    public void setScope(IScope newScope) {
        scope = newScope;
    }

    @Override
    public ITypeSymbol getEvalType() {
        return evalType;
    }

    @Override
    public void setEvalType(ITypeSymbol newEvalType) {
        evalType = newEvalType;
    }

    @Override
    public void setText(String text) {
        //Token should be defined, otherwise it is maybe better to throw a NullPointerException
        this.token.setText(text);
    }

    @Override
    public boolean isDefinedEarlierThan(ITSPHPAst ast) {
        return this.getTokenStartIndex() < ast.getTokenStartIndex();
    }

    @Override
    public List<ITSPHPAst> getChildren() {
        //noinspection unchecked
        return (List<ITSPHPAst>) super.getChildren();
    }

    @Override
    public ITSPHPAst getChild(int index) {
        return (ITSPHPAst) super.getChild(index);
    }
}
