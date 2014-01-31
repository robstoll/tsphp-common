package ch.tsphp.common;

import ch.tsphp.common.exceptions.TSPHPException;

public interface IErrorLogger
{
    void log(TSPHPException ex);
}
