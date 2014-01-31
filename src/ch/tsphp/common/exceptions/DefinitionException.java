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
