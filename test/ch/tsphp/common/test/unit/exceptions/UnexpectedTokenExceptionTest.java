package ch.tsphp.common.test.unit.exceptions;

import ch.tsphp.common.exceptions.UnexpectedTokenException;
import org.antlr.runtime.RecognitionException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UnexpectedTokenExceptionTest
{
    @Test
    public void  getRecognitionException_Standard_ReturnGiven(){
        RecognitionException recognitionException = new RecognitionException();

        UnexpectedTokenException exception = new UnexpectedTokenException("error", recognitionException,"phase");
        RecognitionException result = exception.getRecognitionException();

        assertThat(result, is(recognitionException));
    }

    @Test
    public void  getPhase_Standard_ReturnGiven(){
        //no arrange necessary

        UnexpectedTokenException exception = new UnexpectedTokenException("error", new RecognitionException(),"phase");
        String result = exception.getPhase();

        assertThat(result, is("phase"));
    }
}
