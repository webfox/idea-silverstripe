package com.webfox.silverstripe.structure;

import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.StructureViewModelBase;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.Sorter;
import com.intellij.psi.PsiFile;
import com.webfox.silverstripe.psi.SilverstripeFile;
import org.jetbrains.annotations.NotNull;

public class SilverstripeStructureViewModel extends StructureViewModelBase implements StructureViewModel.ElementInfoProvider {
    public SilverstripeStructureViewModel(PsiFile psiFile) {
        super(psiFile, new SilverstripeStructureViewElement(psiFile));
    }

    @NotNull
    public Sorter[] getSorters() {
        return new Sorter[] {Sorter.ALPHA_SORTER};
    }


    @Override
    public boolean isAlwaysShowsPlus(StructureViewTreeElement element) {
        return false;
    }

    @Override
    public boolean isAlwaysLeaf(StructureViewTreeElement element) {
        return element instanceof SilverstripeFile;
    }
}
