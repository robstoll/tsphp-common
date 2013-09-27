package ch.tutteli.tsphp.common;

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
