package ch.tutteli.tsphp.common.test.unit;

import ch.tutteli.tsphp.common.AstHelperRegistry;
import ch.tutteli.tsphp.common.IAstHelper;
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
