package com.webfox.silverstripe.psi;

import com.intellij.psi.tree.IElementType;
import com.webfox.silverstripe.SilverstripeLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class SilverstripeTokenType extends IElementType {
    public SilverstripeTokenType(@NotNull @NonNls String debugName) {
        super(debugName, SilverstripeLanguage.INSTANCE);
    }
}
