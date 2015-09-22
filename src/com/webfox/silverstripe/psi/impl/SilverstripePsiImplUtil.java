package com.webfox.silverstripe.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.webfox.silverstripe.psi.SilverstripeProperty;
import com.webfox.silverstripe.psi.SilverstripeTypes;
import com.webfox.silverstripe.psi.SilverstripeElementFactory;

public class SilverstripePsiImplUtil {

    public static String getKey(SilverstripeProperty element) {
        ASTNode keyNode = element.getNode().findChildByType(SilverstripeTypes.KEY);
        if (keyNode != null) {
            return keyNode.getText();
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
    
}
