package kratofl.cmclib.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHelper {

    public static boolean senderIsNotPlayer(CommandSender sender) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command mus be executed by a player");
            return true;
        }
        return false;
    }

    public static String getTooManyArgumentsMessage() {
        return ChatColor.RED + "Too many arguments";
    }
}
