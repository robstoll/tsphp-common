package ch.tsphp.common;

import ch.tsphp.common.exceptions.TSPHPException;

public class ConsoleErrorLogger implements IErrorLogger
{

    @Override
    public void log(TSPHPException ex) {
        System.out.println(ex.getMessage());
    }
}
