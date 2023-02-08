package kratofl.cmclib.helper;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

public class BossBarHelper {

    public static BossBar createBossBar(String title, BarColor barColor, double progress, Player player) {
        BossBar bossBar = createNewBossBar(title, barColor, progress);
        bossBar.addPlayer(player);
        return bossBar;
    }
    // This boss bar will be visible for every Player
    public static void createBossBar(String title, BarColor barColor, double progress) {
        BossBar bossBar = createNewBossBar(title, barColor, progress);
        for (Player player : Bukkit.getOnlinePlayers()) {
            bossBar.addPlayer(player);
        }
    }

    private static BossBar createNewBossBar(String title, BarColor barColor, double progress) {
        BossBar bossBar = Bukkit.createBossBar(title, barColor, BarStyle.SEGMENTED_12);
        bossBar.setProgress(progress);
        return bossBar;
    }
}
