/*
 * This file is part of the TSPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.common.test.unit.exceptions;

import ch.tsphp.common.ITSPHPAst;
import ch.tsphp.common.exceptions.DefinitionException;
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
