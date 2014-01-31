package ch.tsphp.common;

import org.antlr.runtime.tree.TreeNodeStream;

/**
 * Represents an translator which translates an ITSPHPAst to an output format.
 *
 * For instance to PHP 5.5, PHP 5.4 etc.
 */
public interface ITranslator extends IErrorReporter
{

    String translate(TreeNodeStream treeNodeStream);
}
