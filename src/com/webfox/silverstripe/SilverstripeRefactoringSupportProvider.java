package com.webfox.silverstripe;

import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.psi.PsiElement;
import com.webfox.silverstripe.psi.SilverstripeProperty;
import org.jetbrains.annotations.NotNull;

public class SilverstripeRefactoringSupportProvider extends RefactoringSupportProvider {
    @Override
    public boolean isMemberInplaceRenameAvailable(@NotNull PsiElement element, PsiElement context) {
        return element instanceof SilverstripeProperty;
    }
}