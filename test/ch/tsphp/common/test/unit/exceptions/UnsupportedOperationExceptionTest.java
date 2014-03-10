/*
 * This file is part of the TSPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.common.test.unit.exceptions;

import ch.tsphp.common.ITSPHPAst;
import org.junit.Test;
import ch.tsphp.common.exceptions.UnsupportedOperationException;

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
