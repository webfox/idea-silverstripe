package com.webfox.silverstripe;

import com.intellij.navigation.ChooseByNameContributor;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.project.Project;
import com.webfox.silverstripe.psi.SilverstripeProperty;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SilverstripeChooseByNameContributor implements ChooseByNameContributor {
    @NotNull
    @Override
    public String[] getNames(Project project, boolean includeNonProjectItems) {
        List<SilverstripeProperty> properties = SilverstripeUtil.findProperties(project);
        List<String> names = new ArrayList<String>(properties.size());
        for (SilverstripeProperty property : properties) {
            if (property.getKey() != null && property.getKey().length() > 0) {
                names.add(property.getKey());
            }
        }
        return names.toArray(new String[names.size()]);
    }

    @NotNull
    @Override
    public NavigationItem[] getItemsByName(String name, String pattern, Project project, boolean includeNonProjectItems) {
        // todo include non project items
        List<SilverstripeProperty> properties = SilverstripeUtil.findProperties(project, name);
        return properties.toArray(new NavigationItem[properties.size()]);
    }
}
