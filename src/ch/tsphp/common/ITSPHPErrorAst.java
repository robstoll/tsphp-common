package ch.tsphp.common;

import ch.tsphp.common.exceptions.TSPHPException;

public interface ITSPHPErrorAst extends ITSPHPAst
{
    TSPHPException getException();
}
