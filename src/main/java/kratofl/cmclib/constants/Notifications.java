package kratofl.cmclib.constants;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;

public class Notifications {

    /**
     * You send to the console a notification
     * @param type - defines the type of the message. default: INFO
     * @param message
     * @param plugin
     */
    public static void sendNotification(NotificationType type, String message, Plugin plugin) {
        if (type == NotificationType.WARNING) {
            Bukkit.getConsoleSender().sendMessage(getWarningPrefix(plugin) + message);
            return;
        }
        if (type == NotificationType.ERROR) {
            Bukkit.getConsoleSender().sendMessage(getErrorPrefix(plugin) + message);
            return;
        }
        Bukkit.getConsoleSender().sendMessage(getInfoPrefix(plugin) + message);
    }

    private static String getWarningPrefix(Plugin plugin) {
        return ChatColor.YELLOW + "[WARNING - " + plugin.getName() + "]: ";
    }
    private static String getErrorPrefix(Plugin plugin) {
        return ChatColor.RED + "[ERROR - " + plugin.getName() + "]: ";
    }
    private static String getInfoPrefix(Plugin plugin) {
        return ChatColor.BLUE + "[INFO - " + plugin.getName() + "]: ";
    }

    public enum NotificationType {
        INFO, WARNING, ERROR
    }
}
