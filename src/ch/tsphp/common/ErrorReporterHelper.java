/*
 * This file is part of the TSPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.common;

import ch.tsphp.common.exceptions.UnexpectedTokenException;
import org.antlr.runtime.RecognitionException;

import java.util.Collection;

public final class ErrorReporterHelper
{
    private ErrorReporterHelper() {
    }

    public static void reportError(
            final Collection<IErrorLogger> errorLoggers,
            final RecognitionException exception,
            final String phase) {

        if (errorLoggers != null) {
            final String tokenText = exception.token != null
                    ? "Unexpected token: " + exception.token.getText()
                    : "Unknown token";
            for (IErrorLogger logger : errorLoggers) {
                logger.log(new UnexpectedTokenException("Line " + exception.line + "|" + exception.charPositionInLine
                        + " exception during " + phase + " phase occurred. " + tokenText, exception, phase));
            }
        }
    }
}
