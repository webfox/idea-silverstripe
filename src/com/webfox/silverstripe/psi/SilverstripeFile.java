package com.webfox.silverstripe.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.webfox.silverstripe.file.SilverstripeFileType;
import com.webfox.silverstripe.SilverstripeLanguage;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class SilverstripeFile extends PsiFileBase {
    public SilverstripeFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, SilverstripeLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return SilverstripeFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Silverstripe File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}