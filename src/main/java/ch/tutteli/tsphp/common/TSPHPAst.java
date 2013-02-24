/*
 * Copyright 2012 Robert Stoll <rstoll@tutteli.ch>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * 
 */
package ch.tutteli.tsphp.common;

import java.util.List;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTree;

/**
 *
 * @author Robert Stoll <rstoll@tutteli.ch>
 *
 * Adopted from the book Language Implementation Patterns by Terence Parr
 */
public class TSPHPAst extends CommonTree implements ITSPHPAst
{

    private IScope scope;
    private ISymbol symbol;
    private ITypeSymbol evalType;

    public TSPHPAst() {
    }

    public TSPHPAst(ITSPHPAst ast) {
        super((CommonTree) ast);
        //CommonTree does not clone token
        token = new CommonToken(token);
        scope = ast.getScope();
        symbol = ast.getSymbol();
        evalType = ast.getEvalType();
    }

    public TSPHPAst(Token t) {
        super(t);
    }

    public Object errorNode(TokenStream input, Token start, Token stop,
            RecognitionException e) {
        TSPHPErrorNode errorNode = new TSPHPErrorNode(input, start, stop, e);
        return errorNode;
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
        return (List<ITSPHPAst>) super.getChildren();
    }

    @Override
    public ITSPHPAst getChild(int i) {
        return (ITSPHPAst) super.getChild(i);
    }
}
