package com.webfox.silverstripe.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.webfox.silverstripe.SilverstripeIcons;
import org.jetbrains.annotations.Nullable;

import java.lang.String;

import com.webfox.silverstripe.psi.SilverstripeProperty;
import com.webfox.silverstripe.psi.SilverstripeTypes;
import com.webfox.silverstripe.psi.SilverstripeElementFactory;

import javax.swing.*;

public class SilverstripePsiImplUtil {

    public static String getKey(SilverstripeProperty element) {
        ASTNode keyNode = element.getNode().findChildByType(SilverstripeTypes.KEY);
        if (keyNode != null) {
            return keyNode.getText().replaceAll("\\\\ ", " ");
        } else {
            return null;
        }
    }

    public static String getValue(SilverstripeProperty element) {
        ASTNode valueNode = element.getNode().findChildByType(SilverstripeTypes.VALUE);
        if (valueNode != null) {
            return valueNode.getText();
        } else {
            return null;
        }
    }

    public static String getName(SilverstripeProperty element) {
        return getKey(element);
    }

    public static PsiElement setName(SilverstripeProperty element, String newName) {
        ASTNode keyNode = element.getNode().findChildByType(SilverstripeTypes.KEY);
        if (keyNode != null) {

            SilverstripeProperty property = SilverstripeElementFactory.createProperty(element.getProject(), newName);
            ASTNode newKeyNode = property.getFirstChild().getNode();
            element.getNode().replaceChild(keyNode, newKeyNode);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(SilverstripeProperty element) {
        ASTNode keyNode = element.getNode().findChildByType(SilverstripeTypes.KEY);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }

    public static ItemPresentation getPresentation(final SilverstripeProperty element) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return element != null ? element.getKey() : null;
            }

            @Nullable
            @Override
            public String getLocationString() {
                return element.getContainingFile() != null ? element.getContainingFile().getName() : null;
            }

            @Nullable
            @Override
            public Icon getIcon(boolean unused) {
                return SilverstripeIcons.FILE;
            }
        };
    }

}
