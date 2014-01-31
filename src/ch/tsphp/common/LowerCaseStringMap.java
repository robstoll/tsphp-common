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
