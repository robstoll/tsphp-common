package ch.tutteli.tsphp.common.test.unit.exceptions;

import ch.tutteli.tsphp.common.ITSPHPAst;
import ch.tutteli.tsphp.common.exceptions.ReferenceException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class ReferenceExceptionTest
{
    @Test
    public void getDefinition_Standard_ReturnGiven(){
        ITSPHPAst ast = mock(ITSPHPAst.class);

        ReferenceException exception = new ReferenceException("error",ast);
        ITSPHPAst result = exception.getDefinition();

        assertThat(result, is(ast));
    }

}
