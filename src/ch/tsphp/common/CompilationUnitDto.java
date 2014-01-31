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