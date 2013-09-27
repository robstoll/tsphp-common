package ch.tutteli.tsphp.common;

import ch.tutteli.tsphp.common.exceptions.TSPHPException;

public interface IErrorLogger
{
    void log(TSPHPException ex);
}
