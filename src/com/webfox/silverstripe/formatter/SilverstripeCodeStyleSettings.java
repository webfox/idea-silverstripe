package com.webfox.silverstripe.formatter;

import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;

public class SilverstripeCodeStyleSettings extends CustomCodeStyleSettings {
    public SilverstripeCodeStyleSettings(CodeStyleSettings settings) {
        super("SilverstripeCodeStyleSettings", settings);
    }
}
