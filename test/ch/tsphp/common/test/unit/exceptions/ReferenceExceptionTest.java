/*
 * This file is part of the TSPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.common.test.unit.exceptions;

import ch.tsphp.common.ITSPHPAst;
import ch.tsphp.common.exceptions.ReferenceException;
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
