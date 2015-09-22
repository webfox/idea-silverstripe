package com.webfox.silverstripe;

import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo;
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider;
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLiteralExpression;
import com.webfox.silverstripe.psi.SilverstripeProperty;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

public class SilverstripeLineMarkerProvider extends RelatedItemLineMarkerProvider {
    @Override
    protected void collectNavigationMarkers(@NotNull PsiElement element, Collection<? super RelatedItemLineMarkerInfo> result) {
        if (element instanceof PsiLiteralExpression) {
            PsiLiteralExpression literalExpression = (PsiLiteralExpression) element;
            String value = (String) literalExpression.getValue();
            if (value != null && value.startsWith(SilverstripeAnnotator.ANNOTATION+":")) {
                Project project = element.getProject();
                final List<SilverstripeProperty> properties = SilverstripeUtil.findProperties(project, value.substring((SilverstripeAnnotator.ANNOTATION_LENGTH+1)));
                if (properties.size() > 0) {
                    NavigationGutterIconBuilder<PsiElement> builder =
                            NavigationGutterIconBuilder.create(SilverstripeIcons.FILE).
                                    setTargets(properties).
                                    setTooltipText("Navigate to a Silverstripe property");
                    result.add(builder.createLineMarkerInfo(element));
                }
            }
        }
    }
}
