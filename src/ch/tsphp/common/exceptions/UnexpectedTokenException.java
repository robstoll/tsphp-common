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

