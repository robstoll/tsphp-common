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
 */
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
    protected IType type;
    protected IScope scope;
    protected TSPHPAst definitionAst;

    public ASymbol(String theName, TSPHPAst theDefinitionAst) {
        name = theName;
        definitionAst = theDefinitionAst;
    }

    @Override
    public TSPHPAst getDefinitionAst() {
        return definitionAst;
    }

    @Override
    public String getName() {
        return name;
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
    public IType getType() {
        return type;
    }

    @Override
    public void setType(IType newType) {
        type = newType;
    }

    @Override
    public String toString() {
        return getEnclosingScopeNames()
                + getName()
                + (type != null ? ":" + type : "");
    }

    private String getEnclosingScopeNames() {
        StringBuilder stringBuilder = new StringBuilder();
        IScope tmpScope = scope;
        while (tmpScope != null) {
            stringBuilder.insert(0, ".");
            stringBuilder.insert(0, tmpScope.getScopeName());
            tmpScope = tmpScope.getEnclosingScope();
        }
        return stringBuilder.toString();
    }

    public static String stripBrackets(String s) {
        return s.substring(1, s.length() - 1);
    }
}
