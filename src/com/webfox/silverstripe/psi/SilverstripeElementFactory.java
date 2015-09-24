package com.webfox.silverstripe.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import com.webfox.silverstripe.file.SilverstripeFileType;

public class SilverstripeElementFactory {

    public static SilverstripeProperty createProperty(Project project, String name, String value) {
        final SilverstripeFile file = createFile(project, name + " = " + value);
        return (SilverstripeProperty) file.getFirstChild();
    }

    public static SilverstripeProperty createProperty(Project project, String name) {
        final SilverstripeFile file = createFile(project, name);
        return (SilverstripeProperty) file.getFirstChild();
    }

    public static PsiElement createCRLF(Project project) {
        final SilverstripeFile file = createFile(project, "\n");
        return file.getFirstChild();
    }

    public static SilverstripeFile createFile(Project project, String text) {
        String name = "dummy.ss";
        return (SilverstripeFile) PsiFileFactory.getInstance(project).createFileFromText(name, SilverstripeFileType.INSTANCE, text);
    }
}
