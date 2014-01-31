package ch.tsphp.common.exceptions;

import ch.tsphp.common.ITSPHPAst;

public class ReferenceException extends TypeCheckerException
{

    private final ITSPHPAst definition;

    public ReferenceException(String message, ITSPHPAst theDefinition) {
        super(message);
        definition = theDefinition;
    }

    public ITSPHPAst getDefinition() {
        return definition;
    }
}
