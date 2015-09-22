package com.webfox.silverstripe;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.indexing.FileBasedIndex;
import com.webfox.silverstripe.file.SilverstripeFileType;
import com.webfox.silverstripe.psi.SilverstripeFile;
import com.webfox.silverstripe.psi.SilverstripeProperty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SilverstripeUtil {

    public static List<SilverstripeProperty> findProperties(Project project, String key) {
        List<SilverstripeProperty> result = null;
        Collection<VirtualFile> virtualFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, SilverstripeFileType.INSTANCE,
                GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            SilverstripeFile silverstripeFile = (SilverstripeFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (silverstripeFile != null) {
                SilverstripeProperty[] properties = PsiTreeUtil.getChildrenOfType(silverstripeFile, SilverstripeProperty.class);
                if (properties != null) {
                    for (SilverstripeProperty property : properties) {
                        if (key.equals(property.getKey())) {
                            if (result == null) {
                                result = new ArrayList<SilverstripeProperty>();
                            }
                            result.add(property);
                        }
                    }
                }
            }
        }
        return result != null ? result : Collections.<SilverstripeProperty>emptyList();
    }

    public static List<SilverstripeProperty> findProperties(Project project) {
        List<SilverstripeProperty> result = new ArrayList<SilverstripeProperty>();
        Collection<VirtualFile> virtualFiles = FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, SilverstripeFileType.INSTANCE,
                GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            SilverstripeFile silverstripeFile = (SilverstripeFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (silverstripeFile != null) {
                SilverstripeProperty[] properties = PsiTreeUtil.getChildrenOfType(silverstripeFile, SilverstripeProperty.class);
                if (properties != null) {
                    Collections.addAll(result, properties);
                }
            }
        }
        return result;
    }

}
