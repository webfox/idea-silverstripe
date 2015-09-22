package com.webfox.silverstripe;

import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class SilverstripeReferenceContributor extends PsiReferenceContributor {
    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(PsiLiteralExpression.class),
                new PsiReferenceProvider() {
                    @NotNull
                    @Override
                    public PsiReference[] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {
                        PsiLiteralExpression literalExpression = (PsiLiteralExpression) element;
                        String text = (String) literalExpression.getValue();
                        if (text != null && text.startsWith(SilverstripeAnnotator.ANNOTATION + ":")) {
                            return new PsiReference[]{new SilverstripeReference(element,
                                    new TextRange((SilverstripeAnnotator.ANNOTATION_LENGTH + 2), text.length() + 1)
                            )};
                        }
                        return new PsiReference[0];
                    }
                });
    }
}
