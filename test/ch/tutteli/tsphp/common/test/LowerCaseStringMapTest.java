/*
 * Copyright 2013 Robert Stoll <rstoll@tutteli.ch>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package ch.tutteli.tsphp.common.test;

import ch.tutteli.tsphp.common.ILowerCaseStringMap;
import ch.tutteli.tsphp.common.LowerCaseStringMap;
import java.util.Arrays;
import java.util.Collection;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author Robert Stoll <rstoll@tutteli.ch>
 */
@RunWith(Parameterized.class)
public class LowerCaseStringMapTest
{

    private String key1;
    private String value1;
    private String key2;
    private String value2;

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

        Assert.assertTrue(a.containsKey(key1));
        Assert.assertTrue(a.containsKey(key2));

        Assert.assertEquals(value1, a.get(key1));
        Assert.assertEquals(value2, a.get(key2));
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
