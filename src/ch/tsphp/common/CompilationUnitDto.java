/*
 * This file is part of the TSPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.common;

import org.antlr.runtime.tree.CommonTreeNodeStream;

public class CompilationUnitDto
{

    public String id;
    public ITSPHPAst compilationUnit;
    public CommonTreeNodeStream treeNodeStream;

    public CompilationUnitDto(String theId, ITSPHPAst theCompilationUnit,
            CommonTreeNodeStream theTreeNodeStream) {
        id = theId;
        compilationUnit = theCompilationUnit;
        treeNodeStream = theTreeNodeStream;
    }
}