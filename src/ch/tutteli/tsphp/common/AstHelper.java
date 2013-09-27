package ch.tutteli.tsphp.common;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.RewriteRuleSubtreeStream;

public class AstHelper implements IAstHelper
{

    private final ITSPHPAstAdaptor astAdaptor;

    public AstHelper(ITSPHPAstAdaptor theAdaptor) {
        astAdaptor = theAdaptor;
    }

    @Override
    public ITSPHPAst createAst(ITSPHPAst ast) {
        return astAdaptor.create(ast);
    }

    @Override
    public ITSPHPAst createAst(int tokenType, String name) {
        return (ITSPHPAst) astAdaptor.create(tokenType, new CommonToken(tokenType, name));
    }

    /**
     * Adopted from http://stackoverflow.com/questions/6781019/antlr-duplicate-a-tree .
     */
    @Override
    public ITSPHPAst copyAst(ITSPHPAst original) {
        ITSPHPAst copy = null;
        //original can be null if backtrack is active
        if (original != null) {
            copy = astAdaptor.create(original); // Leverage constructor

            if (original.getChildren() != null) {
                for (Object child : original.getChildren()) {
                    ITSPHPAst childCopy = copyAst((ITSPHPAst) child);
                    childCopy.setParent(copy);
                    copy.addChild(childCopy);
                }
            }
        }
        return copy;
    }

    @Override
    public void addChildrenFromTo(ITSPHPAst source, ITSPHPAst target) {
        if (source != null) {
            RewriteRuleSubtreeStream stream = new RewriteRuleSubtreeStream(astAdaptor, "classMemberModifiers", source);
            while (stream.hasNext()) {
                astAdaptor.addChild(target, stream.nextTree());
            }
        }
    }

    /**
     * Prepend ast to target, makes ast the parent of target.
     */
    @Override
    public void prependAst(ITSPHPAst ast, ITSPHPAst target) {
        ITSPHPAst parent = (ITSPHPAst) target.getParent();
        int childIndex = target.getChildIndex();
        ast.setParent(parent);
        ast.addChild(target);
        parent.replaceChildren(childIndex, childIndex, ast);
    }
}
