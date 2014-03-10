/*
 * This file is part of the TSPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.common.exceptions;

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
