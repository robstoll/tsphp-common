/*
 * This file is part of the TSPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TSPHP/License
 */

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
