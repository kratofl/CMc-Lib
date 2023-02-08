package kratofl.cmclib.bossbar;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

public class BossBarHelper {

    /**
     * Creates BossBar for one player. 12 Segments
     */
    public static BossBar createBossBar(Player player, String title, BarColor barColor, double progress) {
        return createBossBar(player, title, barColor, BarStyle.SEGMENTED_12, progress);
    }

    /**
     * Creates BossBar for one player
     */
    public static BossBar createBossBar(Player player, String title, BarColor barColor, BarStyle barStyle, double progress) {
        BossBar bossBar = createNewBossBar(title, barColor, barStyle, progress);
        bossBar.addPlayer(player);
        return bossBar;
    }

    /**
     * Creates BossBar for every player. 12 Segments
     */
    public static void createBossBar(String title, BarColor barColor, double progress) {
        createBossBar(title, barColor, BarStyle.SEGMENTED_12, progress);
    }

    /**
     * Creates BossBar for every player
     */
    public static void createBossBar(String title, BarColor barColor, BarStyle barStyle, double progress) {
        BossBar bossBar = createNewBossBar(title, barColor, BarStyle.SEGMENTED_12, progress);
        for (Player player : Bukkit.getOnlinePlayers()) {
            bossBar.addPlayer(player);
        }
    }

    private static BossBar createNewBossBar(String title, BarColor barColor, BarStyle barStyle, double progress) {
        BossBar bossBar = Bukkit.createBossBar(title, barColor, barStyle);
        bossBar.setProgress(progress);
        return bossBar;
    }
}
