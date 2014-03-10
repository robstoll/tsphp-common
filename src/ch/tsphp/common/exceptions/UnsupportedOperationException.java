/*
 * This file is part of the TSPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.common.exceptions;

import ch.tsphp.common.ITSPHPAst;

public class UnsupportedOperationException extends TypeCheckerException
{

    private final ITSPHPAst operator;

    public UnsupportedOperationException(String message, ITSPHPAst theOperator) {
        super(message);
        operator = theOperator;
    }

    public ITSPHPAst getOperator() {
        return operator;
    }
}
