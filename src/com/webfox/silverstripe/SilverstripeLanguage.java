package com.webfox.silverstripe;

import com.intellij.lang.Language;

public class SilverstripeLanguage extends Language {
    public static final SilverstripeLanguage INSTANCE = new SilverstripeLanguage();

    private SilverstripeLanguage() {
        super("Silverstripe");
    }
}