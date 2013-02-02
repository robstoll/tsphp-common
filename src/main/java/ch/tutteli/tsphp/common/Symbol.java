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
public class Symbol
{

    public String name;
    public IType type;
    public IScope scope;
    public TSPHPAst definitionAst;

    public Symbol(String theName) {
        name = theName;
    }

    public Symbol(String name, IType theType) {
        this(name);
        type = theType;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String string = "";
        if (scope != null) {
            string = scope.getScopeName() + ".";
        }
        if (type != null) {
            string = '<' + string + getName() + ":" + type + '>';
        } else {
            string += getName();
        }
        return string;
    }

    public static String stripBrackets(String s) {
        return s.substring(1, s.length() - 1);
    }
}
