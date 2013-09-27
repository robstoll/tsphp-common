package ch.tutteli.tsphp.common;

import org.antlr.runtime.TokenStream;

public class ParserUnitDto
{

    public String id;
    public ITSPHPAst compilationUnit;
    public TokenStream tokenStream;

    public ParserUnitDto(String theId, ITSPHPAst theCompilationUnit, TokenStream theTokenStream) {
        id = theId;
        compilationUnit = theCompilationUnit;
        tokenStream = theTokenStream;
    }
}
