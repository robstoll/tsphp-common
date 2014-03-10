/*
 * This file is part of the TSPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TSPHP/License
 */

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
