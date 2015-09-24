package com.webfox.silverstripe.formatter;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.webfox.silverstripe.SilverstripeLanguage;
import com.webfox.silverstripe.psi.SilverstripeTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SilverstripeFormattingModelBuilder implements FormattingModelBuilder {
    @NotNull
    @Override
    public FormattingModel createModel(PsiElement element, CodeStyleSettings settings) {
        return FormattingModelProvider.createFormattingModelForPsiFile(element.getContainingFile(),
                new SilverstripeBlock(element.getNode(), Wrap.createWrap(WrapType.NONE, false),
                        Alignment.createAlignment(), createSpaceBuilder(settings)), settings);
    }

    private static SpacingBuilder createSpaceBuilder(CodeStyleSettings settings) {
        return new SpacingBuilder(settings, SilverstripeLanguage.INSTANCE)
                .around(SilverstripeTypes.SEPARATOR).spaceIf(settings.SPACE_AROUND_ASSIGNMENT_OPERATORS)
                .before(SilverstripeTypes.PROPERTY).none();
    }

    @Nullable
    @Override
    public TextRange getRangeAffectingIndent(PsiFile file, int offset, ASTNode elementAtOffset) {
        return null;
    }
}