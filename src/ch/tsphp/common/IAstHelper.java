package ch.tsphp.common;

public interface IAstHelper
{

    ITSPHPAst createAst(ITSPHPAst ast);

    ITSPHPAst createAst(int tokenType, String name);

    ITSPHPAst copyAst(ITSPHPAst original);

    void addAstToTargetChildren(ITSPHPAst source, ITSPHPAst target);

    void prependAstToTarget(ITSPHPAst ast, ITSPHPAst target);
}
