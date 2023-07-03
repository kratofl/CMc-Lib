package kratofl.cmclib.enchantments;

import kratofl.cmclib.constants.Notifications;
import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

import java.lang.reflect.Field;

public class CustomEnchantmentManager {

    /**
     * Aadds the custom enchantment with a listener. <br>
     * In that case, the enchantment class is also the listener class
     * @param enchantment
     */
    public static void registerCustomEnchantment(CustomEnchantment enchantment, Plugin plugin) {
        registerCustomEnchantment(enchantment, (Listener) enchantment, plugin);
    }
    /**
     * Adds the custom enchantment with a different listener
     * @param enchantment
     * @param enchantmentEventListener
     */
    public static void registerCustomEnchantment(CustomEnchantment enchantment, Listener enchantmentEventListener, Plugin plugin) {
        try {
            Field field = Enchantment.class.getDeclaredField("acceptingNew");
            field.setAccessible(true);
            field.set(null, true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        registerEnchantment(enchantment, enchantmentEventListener, plugin);
    }
    private static void registerEnchantment(CustomEnchantment enchantment, Listener enchantmentEventListener, Plugin plugin) {
        try {
            Enchantment.registerEnchantment(enchantment);
        } catch (Exception ex) {
            Notifications.sendNotification(Notifications.NotificationType.WARNING, "The enchantment \"" + enchantment.getKey() + "\" has already been registered", plugin);
        }
        Bukkit.getPluginManager().registerEvents(enchantmentEventListener, plugin);
    }
}