/*
 * This file is part of the TSPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.common.exceptions;

import ch.tsphp.common.ITSPHPAst;

public class DefinitionException extends TypeCheckerException
{

    private final ITSPHPAst existingDefinition;
    private final ITSPHPAst newDefinition;

    public DefinitionException(String message, ITSPHPAst theExistingDefinition, ITSPHPAst theNewDefinition) {
        super(message);
        existingDefinition = theExistingDefinition;
        newDefinition = theNewDefinition;
    }

    public ITSPHPAst getExistingDefinition() {
        return existingDefinition;
    }

    public ITSPHPAst getNewDefinition() {
        return newDefinition;
    }
}
