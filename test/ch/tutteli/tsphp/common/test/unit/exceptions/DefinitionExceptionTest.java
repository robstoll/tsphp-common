package ch.tutteli.tsphp.common.test.unit.exceptions;

import ch.tutteli.tsphp.common.ITSPHPAst;
import ch.tutteli.tsphp.common.exceptions.DefinitionException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class DefinitionExceptionTest
{
    @Test
    public void getExistingDefinition_Standard_ReturnExistingAst() {
        ITSPHPAst existingAst = mock(ITSPHPAst.class);

        DefinitionException exception = new DefinitionException("error", existingAst, mock(ITSPHPAst.class));
        ITSPHPAst result = exception.getExistingDefinition();

        assertThat(result, is(existingAst));
    }

    @Test
    public void getNewDefinition_Standard_ReturnNewAst() {
        ITSPHPAst newAst = mock(ITSPHPAst.class);

        DefinitionException exception = new DefinitionException("error", mock(ITSPHPAst.class), newAst);
        ITSPHPAst result = exception.getNewDefinition();

        assertThat(result, is(newAst));
    }
}
