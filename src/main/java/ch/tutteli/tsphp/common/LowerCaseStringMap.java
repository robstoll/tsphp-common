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
package ch.tutteli.tsphp.common;

import java.util.LinkedHashMap;

/**
 *
 * @author Robert Stoll <rstoll@tutteli.ch>
 */
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
