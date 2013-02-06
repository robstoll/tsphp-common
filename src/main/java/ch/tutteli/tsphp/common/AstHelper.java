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
 */
public class AstHelper implements IAstHelper
{

    /**
     * Copied from http://stackoverflow.com/questions/6781019/antlr-duplicate-a-tree
     */
    @Override
    public TSPHPAst copyAst(TSPHPAst original) {

        TSPHPAst copy = new TSPHPAst(original); // Leverage constructor

        if (original.getChildren() != null) {
            for (Object child : original.getChildren()) {
                TSPHPAst childCopy = copyAst((TSPHPAst) child);
                childCopy.setParent(copy);
                copy.addChild(childCopy);
            }
        }
        return copy;
    }
}
