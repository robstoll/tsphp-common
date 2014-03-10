/*
 * This file is part of the TSPHP project published under the Apache License 2.0
 * For the full copyright and license information, please have a look at LICENSE in the
 * root folder or visit the project's website http://tsphp.ch/wiki/display/TSPHP/License
 */

package ch.tsphp.common;

public final class AstHelperRegistry
{

    private static IAstHelper astHelper = new AstHelper(new TSPHPAstAdaptor());

    private AstHelperRegistry() {
    }

    public static void set(IAstHelper newAstHelper) {
        astHelper = newAstHelper;
    }

    public static IAstHelper get() {
        return astHelper;
    }
}
