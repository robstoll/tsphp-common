package ch.tsphp.common.exceptions;

public class TypeCheckerException extends TSPHPException
{

    public TypeCheckerException() {
        //default constructor used by sub-classes
    }

    public TypeCheckerException(String message) {
        super(message);
    }
}
