package ch.tutteli.tsphp.common;

public interface ICompilerListener
{

    void afterParsingAndDefinitionPhaseCompleted();

    void afterReferencePhaseCompleted();

    void afterTypecheckingCompleted();

    void afterCompilingCompleted();
}
