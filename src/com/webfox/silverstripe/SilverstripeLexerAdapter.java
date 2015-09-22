package com.webfox.silverstripe;


import com.intellij.lexer.FlexAdapter;

public class SilverstripeLexerAdapter extends FlexAdapter {
    public SilverstripeLexerAdapter() {
        super(new SilverstripeLexer(null));
    }
}