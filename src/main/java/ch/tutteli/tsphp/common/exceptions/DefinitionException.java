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
package ch.tutteli.tsphp.common.exceptions;

import ch.tutteli.tsphp.common.TSPHPAst;

/**
 *
 * @author Robert Stoll <rstoll@tutteli.ch>
 */
public class DefinitionException extends TypeCheckerException
{

    private TSPHPAst existingDefinition;
    private TSPHPAst newDefinition;

    public DefinitionException(String message, TSPHPAst theExistingDefinition, TSPHPAst theNewDefinition) {
        super(message);
        existingDefinition = theExistingDefinition;
        newDefinition = theNewDefinition;
    }

    public TSPHPAst getExistingDefinition() {
        return existingDefinition;
    }

    public TSPHPAst getNewDefinition() {
        return newDefinition;
    }
}
