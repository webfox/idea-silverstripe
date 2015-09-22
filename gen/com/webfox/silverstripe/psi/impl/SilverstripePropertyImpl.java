// This is a generated file. Not intended for manual editing.
package com.webfox.silverstripe.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.webfox.silverstripe.psi.SilverstripeTypes.*;
import com.webfox.silverstripe.psi.*;

public class SilverstripePropertyImpl extends SilverstripeNamedElementImpl implements SilverstripeProperty {

  public SilverstripePropertyImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SilverstripeVisitor) ((SilverstripeVisitor)visitor).visitProperty(this);
    else super.accept(visitor);
  }

  public String getKey() {
    return SilverstripePsiImplUtil.getKey(this);
  }

  public String getValue() {
    return SilverstripePsiImplUtil.getValue(this);
  }

  public String getName() {
    return SilverstripePsiImplUtil.getName(this);
  }

  public PsiElement setName(String newName) {
    return SilverstripePsiImplUtil.setName(this, newName);
  }

  public PsiElement getNameIdentifier() {
    return SilverstripePsiImplUtil.getNameIdentifier(this);
  }

}
