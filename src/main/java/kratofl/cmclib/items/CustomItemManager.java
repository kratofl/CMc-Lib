package kratofl.cmclib.items;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Optional;

public class CustomItemManager {

    private static HashMap<CustomItem, Listener> customItems = new HashMap<>();

    /**
     * It adds the custom item without a listener
     * @param customItem
     */
    public static void addCustomItem(CustomItem customItem) {
        customItems.put(customItem, null);
    }
    /**
     * It adds the custom item with a listener
     * In that case, the enchantment class is also the listener class
     * @param customItem
     * @param plugin
     */
    public static void addCustomItem(CustomItem customItem, Plugin plugin) {
        customItems.put(customItem, (Listener) customItem);
        registerCustomItemEvent((Listener) customItem, plugin);
    }
    /**
     * It adds the custom item with a different listener
     * @param customItem
     * @param customItemListener
     */
    public static void addCustomItem(CustomItem customItem, Listener customItemListener, Plugin plugin) {
        customItems.put(customItem, customItemListener);
        registerCustomItemEvent(customItemListener, plugin);
    }
    private static void registerCustomItemEvent(Listener customItemListener, Plugin plugin) {
        Bukkit.getPluginManager().registerEvents(customItemListener, plugin);
    }

    @Nullable
    public static ItemStack getCustomItemStack(int id, int amount) {
        Optional<CustomItem> customItem = customItems.keySet().stream().filter((customItemBase -> customItemBase.getId() == id)).findFirst();
        return customItem.map(customItemBase -> customItemBase.getItem(amount)).orElse(null);
    }
}
