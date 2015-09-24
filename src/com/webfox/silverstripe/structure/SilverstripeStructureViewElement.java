package com.webfox.silverstripe.structure;

import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.navigation.NavigationItem;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.webfox.silverstripe.psi.SilverstripeFile;
import com.webfox.silverstripe.psi.SilverstripeProperty;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SilverstripeStructureViewElement implements StructureViewTreeElement, SortableTreeElement {
    private PsiElement element;

    public SilverstripeStructureViewElement(PsiElement element) {
        this.element = element;
    }

    @Override
    public Object getValue() {
        return element;
    }

    @Override
    public void navigate(boolean requestFocus) {
        if (element instanceof NavigationItem) {
            ((NavigationItem) element).navigate(requestFocus);
        }
    }

    @Override
    public boolean canNavigate() {
        return element instanceof NavigationItem &&
                ((NavigationItem)element).canNavigate();
    }

    @Override
    public boolean canNavigateToSource() {
        return element instanceof NavigationItem &&
                ((NavigationItem)element).canNavigateToSource();
    }

    @Override
    @NotNull
    public String getAlphaSortKey() {
        return element instanceof PsiNamedElement ? ((PsiNamedElement) element).getName() : null;
    }

    @Override
    @NotNull
    public ItemPresentation getPresentation() {
        return element instanceof NavigationItem ? ((NavigationItem) element).getPresentation() : null;
    }

    @Override
    @NotNull
    public TreeElement[] getChildren() {
        if (element instanceof SilverstripeFile) {
            SilverstripeProperty[] properties = PsiTreeUtil.getChildrenOfType(element, SilverstripeProperty.class);
            List<TreeElement> treeElements = new ArrayList<TreeElement>(properties != null ? properties.length : 0);
            if(properties != null){
                for (SilverstripeProperty property : properties) {
                    treeElements.add(new SilverstripeStructureViewElement(property));
                }
            }
            return treeElements.toArray(new TreeElement[treeElements.size()]);
        } else {
            return EMPTY_ARRAY;
        }
    }
}
