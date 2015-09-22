package com.webfox.silverstripe.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.webfox.silverstripe.psi.SilverstripeNamedElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SilverstripeNamedElementImpl extends ASTWrapperPsiElement implements SilverstripeNamedElement {
    public SilverstripeNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }

}
