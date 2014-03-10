/*
 * This file is part of the TSPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.common.test.unit;

import ch.tsphp.common.ErrorReporterHelper;
import ch.tsphp.common.IErrorLogger;
import ch.tsphp.common.exceptions.UnexpectedTokenException;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.RecognitionException;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class ErrorReporterHelperTest
{
    @Test
    public void reportError_NoErrorLoggers_doNothing() {
        RecognitionException ex = mock(RecognitionException.class);

        ErrorReporterHelper.reportError(null, ex, "phase");

        verifyNoMoreInteractions(ex);
    }

    @Test
    public void reportError_tokenNull_MessageContainsUnknownToken() {
        RecognitionException ex = mock(RecognitionException.class);
        IErrorLogger errorLogger = mock(IErrorLogger.class);
        Collection<IErrorLogger> errorLoggers = new ArrayList<>();
        errorLoggers.add(errorLogger);

        ErrorReporterHelper.reportError(errorLoggers, ex, "phase");

        ArgumentCaptor<UnexpectedTokenException> captor = ArgumentCaptor.forClass(UnexpectedTokenException.class);
        verify(errorLogger).log(captor.capture());
        assertThat(captor.getValue().getMessage(), containsString("Unknown token"));
    }


    @Test
    public void reportError_tokenNotNull_MessageContainsUnexpectedToken() {
        RecognitionException ex = new RecognitionException();
        ex.token=new CommonToken(1, "token");
        IErrorLogger errorLogger = mock(IErrorLogger.class);
        Collection<IErrorLogger> errorLoggers = new ArrayList<>();
        errorLoggers.add(errorLogger);

        ErrorReporterHelper.reportError(errorLoggers, ex, "phase");

        ArgumentCaptor<UnexpectedTokenException> captor = ArgumentCaptor.forClass(UnexpectedTokenException.class);
        verify(errorLogger).log(captor.capture());
        assertThat(captor.getValue().getMessage(), containsString("Unexpected token"));
    }
}
