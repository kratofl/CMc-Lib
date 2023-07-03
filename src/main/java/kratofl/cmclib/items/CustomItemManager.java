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
     * Adds the custom item without a listener
     * @param customItem
     */
    public static void registerCustomItem(CustomItem customItem) {
        customItems.put(customItem, null);
    }
    /**
     * Adds the custom item with an event listener. <br>
     * In that case, the custom item class is also the event listener class
     * @param customItem
     * @param plugin
     */
    public static void registerCustomItem(CustomItem customItem, Plugin plugin) {
        customItems.put(customItem, (Listener) customItem);
        registerCustomItemEvent((Listener) customItem, plugin);
    }
    /**
     * Adds the custom item with a different listener
     * @param customItem
     * @param seperateItemListener Item events, which are not defined in item class
     */
    public static void registerCustomItem(CustomItem customItem, Listener seperateItemListener, Plugin plugin) {
        customItems.put(customItem, seperateItemListener);
        registerCustomItemEvent(seperateItemListener, plugin);
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