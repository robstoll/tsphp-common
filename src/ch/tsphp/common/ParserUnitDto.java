/*
 * This file is part of the TSPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.common;

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
