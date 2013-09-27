package ch.tutteli.tsphp.common;

public interface IAstHelper
{

    ITSPHPAst createAst(ITSPHPAst ast);

    ITSPHPAst createAst(int tokenType, String name);

    ITSPHPAst copyAst(ITSPHPAst original);

    void addChildrenFromTo(ITSPHPAst source, ITSPHPAst target);

    void prependAst(ITSPHPAst ast, ITSPHPAst target);
}
