/*
 * This file is part of the TSPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.common;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.Tree;

import java.util.List;

public class AstHelper implements IAstHelper
{

    private final ITSPHPAstAdaptor astAdaptor;

    public AstHelper(ITSPHPAstAdaptor theAdaptor) {
        astAdaptor = theAdaptor;
    }

    @Override
    public ITSPHPAst createAst(ITSPHPAst ast) {
        return astAdaptor.clone(ast);
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
            copy = astAdaptor.clone(original); // Leverage constructor

            List<ITSPHPAst> children = original.getChildren();
            if (children != null) {
                for (ITSPHPAst child : children) {
                    ITSPHPAst childCopy = copyAst(child);
                    childCopy.setParent(copy);
                    copy.addChild(childCopy);
                }
            }
        }
        return copy;
    }

    @Override
    public void addAstToTargetChildren(ITSPHPAst ast, ITSPHPAst target) {
        astAdaptor.addChild(target, ast);
    }

    /**
     * Prepend ast to target, makes ast the parent of target.
     */
    @Override
    public void prependAstToTarget(ITSPHPAst ast, ITSPHPAst target) {
        Tree parent = target.getParent();
        int childIndex = target.getChildIndex();
        ast.addChild(target);
        parent.replaceChildren(childIndex, childIndex, ast);
    }
}
