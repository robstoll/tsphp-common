/*
 * This file is part of the TSPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.common;

import java.io.IOException;
import java.io.InputStream;

public interface IParser extends IErrorReporter
{

    /**
     * Parse the inputString and return the corresponding abstract syntax ITSPHPAst (AST).
     *
     * @return An abstract syntax ITSPHPAst (AST)
     * @see <a href="http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRStringStream.html">
     * http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRStringStream.html</a>
     */
    ParserUnitDto parse(String inputString);

    /**
     * Parse the data and return the corresponding abstract syntax ITSPHPAst (AST).
     *
     * @return An abstract syntax ITSPHPAst (AST)
     * @see <a href="http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRStringStream.html">
     * http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRStringStream.html</a>
     */
    ParserUnitDto parse(char[] data, int numberOfActualCharsInArray);

    /**
     * Parse the inputStream and return the corresponding abstract syntax ITSPHPAst (AST).
     *
     * @return An abstract syntax ITSPHPAst (AST)
     * @see <a href="http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRInputStream.html">
     * http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRInputStream.html</a>
     */
    ParserUnitDto parseInputStream(InputStream input) throws IOException;

    /**
     * Parse the inputStream and return the corresponding abstract syntax ITSPHPAst (AST).
     *
     * @return An abstract syntax ITSPHPAst (AST)
     * @see <a href="http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRInputStream.html">
     * http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRInputStream.html</a>
     */
    ParserUnitDto parseInputStream(InputStream input, int initialBufferSize) throws IOException;

    /**
     * Parse the inputStream and return the corresponding abstract syntax ITSPHPAst (AST).
     *
     * @return An abstract syntax ITSPHPAst (AST)
     * @see <a href="http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRInputStream.html">
     * http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRInputStream.html</a>
     */
    ParserUnitDto parseInputStream(InputStream input, String encoding) throws IOException;

    /**
     * Parse the inputStream and return the corresponding abstract syntax ITSPHPAst (AST).
     *
     * @return An abstract syntax ITSPHPAst (AST)
     * @see <a href="http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRInputStream.html">
     * http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRInputStream.html</a>
     */
    ParserUnitDto parseInputStream(InputStream input, int initialBufferSize, String encoding) throws IOException;

    /**
     * Parse the inputStream and return the corresponding abstract syntax ITSPHPAst (AST).
     *
     * @return An abstract syntax ITSPHPAst (AST)
     * @see <a href="http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRInputStream.html">
     * http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRInputStream.html</a>
     */
    ParserUnitDto parseInputStream(InputStream input, int initialBufferSize, int readBufferSize, String encoding)
            throws IOException;

    /**
     * Parse the file and return the corresponding abstract syntax ITSPHPAst (AST).
     *
     * @return An abstract syntax ITSPHPAst (AST)
     * @see <a href="http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRFileStream.html">
     * http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRFileStream.html</a>
     */
    ParserUnitDto parseFile(String filename) throws IOException;

    /**
     * Parse the file and return the corresponding abstract syntax ITSPHPAst (AST).
     *
     * @return An abstract syntax ITSPHPAst (AST)
     * @see <a href="http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRFileStream.html">
     * http://www.antlr3.org/api/Java/org/antlr/runtime/ANTLRFileStream.html</a>
     */
    ParserUnitDto parseFile(String fileName, String encoding) throws IOException;

    /**
     * Indicate whether one or more syntax errors have been found during the check.
     *
     * @return True if errors have been found otherwise false.
     */
    @Override
    boolean hasFoundError();
}
