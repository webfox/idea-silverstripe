package com.webfox.silverstripe.psi;

import com.intellij.psi.tree.IElementType;
import com.webfox.silverstripe.SilverstripeLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class SilverstripeElementType extends IElementType {
    public SilverstripeElementType(@NotNull @NonNls String debugName) {
        super(debugName, SilverstripeLanguage.INSTANCE);
    }
}
