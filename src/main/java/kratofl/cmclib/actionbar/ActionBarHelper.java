package kratofl.cmclib.actionbar;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class ActionBarHelper {

    /**
     * Send an ActionBar to one player, which will disappear after 2.5 seconds or stays permanent
     */
    public static void sendActionBar(Player player, String message, Plugin plugin, boolean permanent) {
        if (permanent) {
            sendPermanentActionBarToPlayer(player, message, plugin);
            return;
        }
        sendActionBarToPlayer(player, message);
    }
    /**
     * Send an ActionBar to one player, which will disappear after some seconds, you've declared
     */
    public static void sendActionBar(Player player, String message, Plugin plugin, int seconds) {
        sendTimedActionBarToPlayer(player, message, plugin, seconds);
    }


    /**
     * Send an ActionBar to every player, which will disappear after 2.5 seconds or stays permanent
     */
    public static void sendActionBar(String message, Plugin plugin, boolean permanent) {
        if (permanent) {
            sendPermanentActionBarToEveryPlayer(message, plugin);
            return;
        }
        sendActionBarToEveryPlayer(message);
    }
    /**
     * Send an ActionBar to every player, which will disappear after some seconds, you've declared
     */
    public static void sendActionBar(String message, Plugin plugin, int seconds) {
        sendTimedActionBarToEveryPlayer(message, plugin, seconds);
    }

    private static void sendActionBarToPlayer(Player player, String message) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(message));
    }
    private static int sendPermanentActionBarToPlayer(Player player, String message, Plugin plugin) {
        return Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            sendActionBarToPlayer(player, message);
        }, 0, 40);
    }
    private static void sendTimedActionBarToPlayer(Player player, String message, Plugin plugin, int seconds) {
        int taskId = sendPermanentActionBarToPlayer(player, message, plugin);

        // Kills the permanent ActionBar after "seconds" s.
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, () -> {
            Bukkit.getScheduler().cancelTask(taskId);
        }, 20L * seconds);
    }

    private static void sendActionBarToEveryPlayer(String message) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            sendActionBarToPlayer(player, message);
        }
    }
    private static void sendPermanentActionBarToEveryPlayer(String message, Plugin plugin) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            sendPermanentActionBarToPlayer(player, message, plugin);
        }
    }
    private static void sendTimedActionBarToEveryPlayer(String message, Plugin plugin, int seconds) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            sendTimedActionBarToPlayer(player, message, plugin, seconds);
        }
    }
}
