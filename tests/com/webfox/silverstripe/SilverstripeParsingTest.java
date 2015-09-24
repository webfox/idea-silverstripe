package com.webfox.silverstripe;

import com.intellij.testFramework.ParsingTestCase;

public class SilverstripeParsingTest extends ParsingTestCase {
    public SilverstripeParsingTest() {
        super("", "ss", new SilverstripeParserDefinition());
    }

    public void testParsingTestData() {
        doTest(true);
    }

    @Override
    protected String getTestDataPath() {
        return "./testData";
    }

    @Override
    protected boolean skipSpaces() {
        return false;
    }

    @Override
    protected boolean includeRanges() {
        return true;
    }
}