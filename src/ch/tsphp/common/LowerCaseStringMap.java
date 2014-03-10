/*
 * This file is part of the TSPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.common;

import java.util.LinkedHashMap;

public class LowerCaseStringMap<TValue> extends LinkedHashMap<String, TValue> implements ILowerCaseStringMap<TValue>
{

    @Override
    public TValue get(Object key) {
        
        return super.get(key.toString().toLowerCase());
    }

    @Override
    public boolean containsKey(Object key) {
        return super.containsKey(key.toString().toLowerCase());
    }

    @Override
    public TValue put(String key, TValue symbols) {
        return super.put(key.toLowerCase(), symbols);
    }
}
