package kratofl.cmclib.helper;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class ActionBarHelper {

    public static void createNewActionBar(String text, Player player) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(text));
    }
    // All Players
    public static void createNewActionBar(String text, Plugin plugin) {
        sendActionBar(text, plugin);
    }

    private static void sendActionBar(String message, Plugin plugin)
    {
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(message));
            }
        }, 0, 40);
    }
}
