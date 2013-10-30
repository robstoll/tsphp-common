package ch.tutteli.tsphp.common.test.unit;

import ch.tutteli.tsphp.common.AstHelper;
import ch.tutteli.tsphp.common.IAstHelper;
import ch.tutteli.tsphp.common.ITSPHPAst;
import ch.tutteli.tsphp.common.ITSPHPAstAdaptor;
import org.antlr.runtime.CommonToken;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AstHelperTest
{
    private ITSPHPAstAdaptor astAdaptor;

    @Before
    public void setUp() {
        astAdaptor = mock(ITSPHPAstAdaptor.class);
    }

    @Test
    public void cloneAst_Standard_DelegatesToAdaptor() {
        ITSPHPAst ast = mock(ITSPHPAst.class);
        ITSPHPAst ast2 = mock(ITSPHPAst.class);
        when(astAdaptor.clone(ast)).thenReturn(ast2);

        IAstHelper astHelper = createAstHelper();
        ITSPHPAst result = astHelper.createAst(ast);

        assertThat(result, is(ast2));
        verify(astAdaptor).clone(ast);
    }

    @Test
    public void createAst_Standard_DelegatesToAdaptor() {
        ITSPHPAst ast = mock(ITSPHPAst.class);
        when(astAdaptor.create(anyInt(), any(CommonToken.class))).thenReturn(ast);

        IAstHelper astHelper = createAstHelper();
        ITSPHPAst result = astHelper.createAst(1, "token");

        assertThat(result, is(ast));
        ArgumentCaptor<CommonToken> token = ArgumentCaptor.forClass(CommonToken.class);
        ArgumentCaptor<Integer> tokenType = ArgumentCaptor.forClass(Integer.class);
        verify(astAdaptor).create(tokenType.capture(), token.capture());
        assertThat(tokenType.getValue(), is(1));
        assertThat(token.getValue().getText(), is("token"));
    }

    @Test
    public void copyAst_OriginalIsNull_ReturnNull() {
        //Arrange not needed

        IAstHelper astHelper = createAstHelper();
        ITSPHPAst result = astHelper.copyAst(null);

        assertNull(result);
    }

    @Test
    public void copyAst_NoChildren_CallAdaptorsClone() {
        ITSPHPAst original = mock(ITSPHPAst.class);
        ITSPHPAst clone = mock(ITSPHPAst.class);
        when(astAdaptor.clone(original)).thenReturn(clone);
        when(original.getChildren()).thenReturn(null);

        IAstHelper astHelper = createAstHelper();
        ITSPHPAst result = astHelper.copyAst(original);

        assertThat(result, is(clone));
        verify(astAdaptor).clone(original);
        verify(original).getChildren();
    }

    @Test
    public void copyAst_OneChildWithoutChildren_CallAdaptorsCloneAndCopyChild() {
        ITSPHPAst original = mock(ITSPHPAst.class);
        ITSPHPAst clone = createClone(original);
        ITSPHPAst child = mock(ITSPHPAst.class);
        ITSPHPAst childClone = createClone(child);
        List<ITSPHPAst> list = new ArrayList<>();
        list.add(child);
        when(original.getChildren()).thenReturn(list);

        //act
        IAstHelper astHelper = createAstHelper();
        ITSPHPAst result = astHelper.copyAst(original);

        assertThat(result, is(clone));
        verify(astAdaptor).clone(original);
        verify(original).getChildren();
        verify(astAdaptor).clone(child);
        verify(child).getChildren();
        verify(childClone).setParent(clone);
        verify(clone).addChild(childClone);
    }

    @Test
    public void copyAst_TwoChildrenWithoutChildren_CallAdaptorsCloneAndCopyChildren() {
        ITSPHPAst original = mock(ITSPHPAst.class);
        ITSPHPAst clone = createClone(original);
        ITSPHPAst child1 = mock(ITSPHPAst.class);
        ITSPHPAst child2 = mock(ITSPHPAst.class);
        ITSPHPAst child1Clone = createClone(child1);
        ITSPHPAst child2Clone = createClone(child2);
        List<ITSPHPAst> list = new ArrayList<>();
        list.add(child1);
        list.add(child2);
        when(original.getChildren()).thenReturn(list);


        //act
        IAstHelper astHelper = createAstHelper();
        ITSPHPAst result = astHelper.copyAst(original);


        assertThat(result, is(clone));
        verify(astAdaptor).clone(original);
        verify(original).getChildren();

        //clone children
        verify(astAdaptor).clone(child1);
        verify(child1).getChildren();
        verify(child1Clone).setParent(clone);
        verify(clone).addChild(child1Clone);

        verify(astAdaptor).clone(child2);
        verify(child2).getChildren();
        verify(child2Clone).setParent(clone);
        verify(clone).addChild(child2Clone);
    }

    @Test
    public void copyAst_OneChildWithTwoChildren_CallAdaptorsCloneAndCopyChildAndItsChildren() {
        ITSPHPAst original = mock(ITSPHPAst.class);
        ITSPHPAst clone = createClone(original);
        ITSPHPAst child = mock(ITSPHPAst.class);
        ITSPHPAst childClone = createClone(child);
        List<ITSPHPAst> list = new ArrayList<>();
        list.add(child);
        when(original.getChildren()).thenReturn(list);

        ITSPHPAst child1 = mock(ITSPHPAst.class);
        ITSPHPAst child2 = mock(ITSPHPAst.class);
        ITSPHPAst child1Clone = createClone(child1);
        ITSPHPAst child2Clone = createClone(child2);
        List<ITSPHPAst> listChild = new ArrayList<>();
        listChild.add(child1);
        listChild.add(child2);
        when(child.getChildren()).thenReturn(listChild);


        //act
        IAstHelper astHelper = createAstHelper();
        ITSPHPAst result = astHelper.copyAst(original);


        assertThat(result, is(clone));
        verify(astAdaptor).clone(original);
        verify(original).getChildren();

        //clone child
        verify(astAdaptor).clone(child);
        verify(child).getChildren();
        verify(childClone).setParent(clone);

        //clone children
        verify(astAdaptor).clone(child1);
        verify(child1).getChildren();
        verify(child1Clone).setParent(childClone);
        verify(childClone).addChild(child1Clone);

        verify(astAdaptor).clone(child2);
        verify(child2).getChildren();
        verify(child2Clone).setParent(childClone);
        verify(childClone).addChild(child2Clone);
    }

    @Test
    //astAdaptor will will check for null
    public void addAstToTargetChildren_SourceIsNull_DelegateToAdaptor() {
        ITSPHPAst target = mock(ITSPHPAst.class);

        IAstHelper astHelper = createAstHelper();
        astHelper.addAstToTargetChildren(null, target);

        verify(astAdaptor).addChild(target, null);
    }

    @Test
    public void addAstToTargetChildren_SourceIsNotNull_DelegateToAdaptor() {
        ITSPHPAst ast = mock(ITSPHPAst.class);
        ITSPHPAst target = mock(ITSPHPAst.class);

        IAstHelper astHelper = createAstHelper();
        astHelper.addAstToTargetChildren(ast, target);

        verify(astAdaptor).addChild(target, ast);
    }

    @Test
    public void prependAstToTarget_Standard_AddTargetToAstChildrenAndCallReplaceChildrenOnOldParent() {
        ITSPHPAst ast = mock(ITSPHPAst.class);
        ITSPHPAst target = mock(ITSPHPAst.class);
        ITSPHPAst parent = mock(ITSPHPAst.class);
        when(target.getParent()).thenReturn(parent);
        when(target.getChildIndex()).thenReturn(123);

        IAstHelper astHelper = createAstHelper();
        astHelper.prependAstToTarget(ast, target);

        verify(ast).addChild(target);
        verify(parent).replaceChildren(123, 123, ast);
    }

    private IAstHelper createAstHelper() {
        return new AstHelper(astAdaptor);
    }

    private ITSPHPAst createClone(ITSPHPAst child) {
        ITSPHPAst childClone = mock(ITSPHPAst.class);
        when(astAdaptor.clone(child)).thenReturn(childClone);
        return childClone;
    }
}
