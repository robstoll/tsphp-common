package ch.tsphp.common;

import org.antlr.runtime.tree.TreeNodeStream;

public interface ITypeChecker extends IErrorReporter
{

    void enrichWithDefinitions(ITSPHPAst ast, TreeNodeStream treeNodeStream);

    void enrichWithReferences(ITSPHPAst ast, TreeNodeStream treeNodeStream);
    
    void doTypeChecking(ITSPHPAst ast, TreeNodeStream treeNodeStream);
    
    /**
     * Reset the type checker.
     * 
     * It will forget about previous definitions etc. next to drop previous exceptions
     */
    @Override
    void reset();
}
