package ch.tsphp.common.test.unit;

import ch.tsphp.common.ILowerCaseStringMap;
import ch.tsphp.common.LowerCaseStringMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class LowerCaseStringMapTest
{

    private final String key1;
    private final String value1;
    private final String key2;
    private final String value2;

    public LowerCaseStringMapTest(String k1, String v1, String k2, String v2) {
        key1 = k1;
        value1 = v1;
        key2 = k2;
        value2 = v2;
    }

    @Test
    public void testOrder() {
        ILowerCaseStringMap<String> a = new LowerCaseStringMap<>();
        a.put(key1, value1);
        a.put(key2, value2);

        assertTrue(a.containsKey(key1));
        assertTrue(a.containsKey(key2));

        assertThat(a.get(key1), is(value1));
        assertThat(a.get(key2), is(value2));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testStrings() {
        return Arrays.asList(new Object[][]{
                    {"1", "2", "3", "4"},
                    {"a", "b", "c", "d"},
                    {"t", "z", "u", "o"}
        });
    }
}
