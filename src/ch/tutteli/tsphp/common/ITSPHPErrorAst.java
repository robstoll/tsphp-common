package ch.tutteli.tsphp.common;

import ch.tutteli.tsphp.common.exceptions.TSPHPException;

public interface ITSPHPErrorAst extends ITSPHPAst
{
    TSPHPException getException();
}
