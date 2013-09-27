package ch.tutteli.tsphp.common.exceptions;

public class TSPHPException extends Exception
{

    public TSPHPException() {
        //default constructor used by sub-classes
    }

    public TSPHPException(String message) {
        super(message);
    }

    public TSPHPException(Throwable cause) {
        super(cause);
    }

    public TSPHPException(String message, Throwable cause) {
        super(message, cause);
    }
}
