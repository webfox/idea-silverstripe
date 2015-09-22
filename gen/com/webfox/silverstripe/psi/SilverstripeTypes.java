// This is a generated file. Not intended for manual editing.
package com.webfox.silverstripe.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.webfox.silverstripe.psi.impl.*;

public interface SilverstripeTypes {

  IElementType PROPERTY = new SilverstripeElementType("PROPERTY");

  IElementType COMMENT = new SilverstripeTokenType("COMMENT");
  IElementType CRLF = new SilverstripeTokenType("CRLF");
  IElementType KEY = new SilverstripeTokenType("KEY");
  IElementType SEPARATOR = new SilverstripeTokenType("SEPARATOR");
  IElementType VALUE = new SilverstripeTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == PROPERTY) {
        return new SilverstripePropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
