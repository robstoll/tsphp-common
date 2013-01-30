/*
 * Copyright 2012 Robert Stoll <rstoll@tutteli.ch>
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

import java.util.List;

/**
 *
 * @author Robert Stoll <rstoll@tutteli.ch>
 */
public interface IErrorReporter
{
      /**
     * Indicate whether one or more errors have been found.
     *
     * @return True if errors have been found otherwise false.
     */
    boolean hasFoundError();

    /**
     * Return the found errors as a list of exceptions.
     *
     * @return The found errors
     */
    List<Exception> getExceptions();
}
