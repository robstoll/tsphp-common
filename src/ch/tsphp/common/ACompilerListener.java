/*
 * This file is part of the TSPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.common;

public abstract class ACompilerListener implements ICompilerListener
{

    protected ACompilerListener() {
        //Prevent instantiation - implement subclass and do not use this class directly
    }

    @Override
    public void afterParsingAndDefinitionPhaseCompleted() {
        //Override if you want to listen to this event
    }

    @Override
    public void afterReferencePhaseCompleted() {
        //Override if you want to listen to this event
    }

    @Override
    public void afterTypecheckingCompleted() {
        //Override if you want to listen to this event
    }

    @Override
    public void afterCompilingCompleted() {
        //Override if you want to listen to this event
    }
}
