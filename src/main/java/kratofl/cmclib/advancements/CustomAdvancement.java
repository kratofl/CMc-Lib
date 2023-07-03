package kratofl.cmclib.advancements;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import kratofl.cmclib.advancements.adapter.ListAdapter;
import kratofl.cmclib.advancements.adapter.MapAdapter;
import kratofl.cmclib.advancements.constants.Background;
import kratofl.cmclib.advancements.constants.FrameType;
import kratofl.cmclib.advancements.objs.Criteria;
import kratofl.cmclib.advancements.objs.Display;
import kratofl.cmclib.constants.Notifications;
import kratofl.cmclib.helper.JsonHelper;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.advancement.Advancement;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomAdvancement {

    private NamespacedKey id;

    @Expose
    private String parent;
    @Expose
    private Map<String, Criteria> criteria = new HashMap<>();
    @Expose
    private Display display;

    /**
     * @param plugin provide namespace
     * @param namespaceKey
     * @param title
     * @param description
     * @param iconMaterial
     */
    public CustomAdvancement(Plugin plugin, String namespaceKey, String title, String description, Material iconMaterial) {
        this.id = new NamespacedKey(plugin, namespaceKey);
        this.display = new Display(title, description, iconMaterial);
    }

    public void load(Plugin plugin) {
        if (criteria.size() < 1) {
            Notifications.sendNotification(Notifications.NotificationType.ERROR, "Please provide at least ONE criteria", plugin);
            return;
        }

        Advancement advancement = Bukkit.getAdvancement(id);
        if (advancement == null) {
            try {
                advancement = Bukkit.getUnsafe().loadAdvancement(id, JsonHelper.getJsonFromClass(this));
            } catch (IllegalArgumentException e) {
                Bukkit.getLogger().severe("Can't load advancement " + id.toString());
            }
        }
    }

    public CustomAdvancement setParent(@NotNull CustomAdvancement advancement) {
        parent = advancement.id.toString();
        return this;
    }

    public CustomAdvancement addCriteria(Criteria criteria) {
        this.criteria.put(criteria.getName(), criteria);
        return this;
    }
}