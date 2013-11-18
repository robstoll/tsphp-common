package ch.tutteli.tsphp.common.test.unit.exceptions;

import ch.tutteli.tsphp.common.ITSPHPAst;
import org.junit.Test;
import ch.tutteli.tsphp.common.exceptions.UnsupportedOperationException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class UnsupportedOperationExceptionTest
{
    @Test
    public void getOperator_Standard_ReturnGiven(){
        ITSPHPAst operator = mock(ITSPHPAst.class);

        UnsupportedOperationException exception = new UnsupportedOperationException("error", operator);
        ITSPHPAst result = exception.getOperator();

        assertThat(result, is(operator));
    }
}
