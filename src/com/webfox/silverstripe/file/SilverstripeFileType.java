package com.webfox.silverstripe.file;

import com.webfox.silverstripe.SilverstripeIcons;
import com.webfox.silverstripe.SilverstripeLanguage;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class SilverstripeFileType extends LanguageFileType {
    public static final SilverstripeFileType INSTANCE = new SilverstripeFileType();

    protected SilverstripeFileType() {
        super(SilverstripeLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Silverstripe";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Silverstripe template file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "ss";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return SilverstripeIcons.FILE;
    }
}