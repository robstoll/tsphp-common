/*
 * This file is part of the TSPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.common.test.unit;

import ch.tsphp.common.AstHelperRegistry;
import ch.tsphp.common.IAstHelper;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class AstHelperRegistryTest
{

    @Test
    public void setAndGet_Standard_ReturnSetAstHelper() {
        IAstHelper astHelper = mock(IAstHelper.class);

        AstHelperRegistry.set(astHelper);
        IAstHelper result = AstHelperRegistry.get();

        assertThat(result, is(astHelper));
    }

    @Test
    public void setTwiceAndGet_Standard_ReturnSecondSet() {
        IAstHelper astHelper = mock(IAstHelper.class);
        IAstHelper astHelper2 = mock(IAstHelper.class);

        AstHelperRegistry.set(astHelper);
        AstHelperRegistry.set(astHelper2);
        IAstHelper result = AstHelperRegistry.get();

        assertThat(result, is(astHelper2));
    }
}
