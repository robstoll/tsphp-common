/*
 * This file is part of the TSPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.common.exceptions;

import org.antlr.runtime.RecognitionException;

public class UnexpectedTokenException extends TSPHPException
{
    private final RecognitionException recognitionException;
    private final String phase;

    public UnexpectedTokenException(String message, RecognitionException theRecognitionException, String thePhase) {
        super(message);
        recognitionException = theRecognitionException;
        phase = thePhase;
    }

    public RecognitionException getRecognitionException() {
        return recognitionException;
    }

    public String getPhase() {
        return phase;
    }
}

