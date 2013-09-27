package ch.tutteli.tsphp.common;

public interface IErrorReporter
{

    /**
     * Add the given error logger as listener for errors. 
     * 
     * The error reporter will pass all errors detected to the error logger.
     */
    void addErrorLogger(IErrorLogger logger);

    /**
     * Indicate whether one or more errors have been found.
     *
     * @return True if errors have been found otherwise false.
     */
    boolean hasFoundError();
    
    /**
     * Drop previous exceptions
     */
    void reset();
}
