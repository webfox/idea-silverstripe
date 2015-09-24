package com.webfox.silverstripe.formatter;

import com.intellij.application.options.CodeStyleAbstractConfigurable;
import com.intellij.application.options.CodeStyleAbstractPanel;
import com.intellij.application.options.TabbedLanguageCodeStylePanel;
import com.intellij.openapi.options.Configurable;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CodeStyleSettingsProvider;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;
import com.webfox.silverstripe.SilverstripeLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SilverstripeCodeStyleSettingsProvider extends CodeStyleSettingsProvider {

    @Override
    public CustomCodeStyleSettings createCustomSettings(CodeStyleSettings settings) {
        return new SilverstripeCodeStyleSettings(settings);
    }

    @Nullable
    @Override
    public String getConfigurableDisplayName() {
        return "Silverstripe";
    }

    @NotNull
    @Override
    public Configurable createSettingsPage(CodeStyleSettings settings, CodeStyleSettings originalSettings) {
        return new CodeStyleAbstractConfigurable(settings, originalSettings, "Silverstripe") {
            @Override
            protected CodeStyleAbstractPanel createPanel(CodeStyleSettings settings) {
                return new SilverstripeCodeStyleMainPanel(getCurrentSettings(), settings);
            }

            @Nullable
            @Override
            public String getHelpTopic() {
                return null;
            }
        };
    }

    private static class SilverstripeCodeStyleMainPanel extends TabbedLanguageCodeStylePanel {
        public SilverstripeCodeStyleMainPanel(CodeStyleSettings currentSettings, CodeStyleSettings settings) {
            super(SilverstripeLanguage.INSTANCE, currentSettings, settings);
        }
    }
}