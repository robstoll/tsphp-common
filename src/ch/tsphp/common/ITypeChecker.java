/*
 * This file is part of the TSPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TSPHP/License
 */

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
