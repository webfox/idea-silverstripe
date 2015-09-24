package com.webfox.silverstripe;

import com.intellij.lang.annotation.Annotation;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLiteralExpression;
import com.webfox.silverstripe.intention.CreatePropertyQuickFix;
import com.webfox.silverstripe.psi.SilverstripeProperty;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SilverstripeAnnotator implements Annotator {
    public static final String ANNOTATION = "silverstripe";
    public static final int ANNOTATION_LENGTH = 12;

    @Override
    public void annotate(@NotNull final PsiElement element, @NotNull AnnotationHolder holder) {
        if (element instanceof PsiLiteralExpression) {
            PsiLiteralExpression literalExpression = (PsiLiteralExpression) element;
            String value = (String) literalExpression.getValue();
            if (value != null && value.startsWith(ANNOTATION+":")) {
                Project project = element.getProject();
                String key = value.substring((ANNOTATION_LENGTH+1));
                List<SilverstripeProperty> properties = SilverstripeUtil.findProperties(project, key);
                if (properties.size() == 1) {
                    Integer TextRangeOffset = element.getTextRange().getStartOffset() + (ANNOTATION_LENGTH+1);
                    Annotation annotation = holder.createInfoAnnotation(new TextRange(TextRangeOffset, TextRangeOffset), null);
                    annotation.setTextAttributes(DefaultLanguageHighlighterColors.LINE_COMMENT);
                } else if (properties.size() == 0) {
                    TextRange range = new TextRange(element.getTextRange().getStartOffset() + (ANNOTATION_LENGTH+2), element.getTextRange().getEndOffset());
                    holder.createErrorAnnotation(range, "Unresolved property").registerFix(new CreatePropertyQuickFix(key));
                }
            }
        }
    }
}