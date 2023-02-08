package kratofl.cmclib.advancements;

import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public abstract class CustomAdvancementTree {

    private ArrayList<CustomAdvancement> advancements = new ArrayList<>();

    public CustomAdvancementTree() {
        this.addRootAdvancement();
    }

    public final void addChildAdvancement(CustomAdvancement customAdvancement) {
        this.advancements.add(customAdvancement);
    }
    public final void loadCustomAdvancements(Plugin plugin) {
        for (CustomAdvancement customAdvancement : this.advancements) {
            customAdvancement.load(plugin);
        }
    }
    protected final void addRootAdvancement() {
        this.advancements.add(getRootAdvancement());
    }

    protected abstract CustomAdvancement getRootAdvancement();
}
