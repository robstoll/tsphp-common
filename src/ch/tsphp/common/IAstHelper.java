/*
 * This file is part of the TSPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.common;

public interface IAstHelper
{

    ITSPHPAst createAst(ITSPHPAst ast);

    ITSPHPAst createAst(int tokenType, String name);

    ITSPHPAst copyAst(ITSPHPAst original);

    void addAstToTargetChildren(ITSPHPAst source, ITSPHPAst target);

    void prependAstToTarget(ITSPHPAst ast, ITSPHPAst target);
}
