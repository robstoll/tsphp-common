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
