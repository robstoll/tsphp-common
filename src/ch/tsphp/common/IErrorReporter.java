/*
 * This file is part of the TSPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.common;

public interface IErrorReporter
{

    /**
     * Add the given error logger as listener for errors. 
     * 
     * The error reporter will pass all errors detected to the registered error loggers.
     */
    void registerErrorLogger(IErrorLogger logger);

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
