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

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonErrorNode;

/**
 *
 * @author Robert Stoll <rstoll@tutteli.ch>
 *
 * Adopted from the book Language Implementation Patterns by Terence Parr
 */
public class TSPHPErrorNode extends TSPHPAst
{

    CommonErrorNode errorNode;

    public TSPHPErrorNode(TokenStream input, Token start, Token stop, RecognitionException exception) {
        super(start);
        errorNode = new CommonErrorNode(input, start, stop, exception);
    }

    @Override
    public boolean isNil() {
        return errorNode.isNil();
    }

    @Override
    public int getType() {
        return errorNode.getType();
    }

    @Override
    public String getText() {
        return errorNode.getText();
    }

    @Override
    public String toString() {
        return errorNode.toString();
    }
}