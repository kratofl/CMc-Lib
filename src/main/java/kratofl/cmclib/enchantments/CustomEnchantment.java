package kratofl.cmclib.enchantments;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

public class CustomEnchantment extends Enchantment {

    public CustomEnchantment(NamespacedKey key, String name, int maxLevel, boolean isTreasure, boolean isCursed) {
        super(key);
        this.name = name;
        this.maxLevel = maxLevel;
        this.isTreasure = isTreasure;
        this.isCursed = isCursed;
    }

    private final String name;
    private final int maxLevel;
    private final boolean isTreasure;
    private final boolean isCursed;

    @Override
    public String getName() {
        return name;
    }
    @Override
    public int getMaxLevel() {
        return maxLevel;
    }
    @Override
    public int getStartLevel() {
        return 1;
    }
    @Override
    public EnchantmentTarget getItemTarget() {
        return null;
    }
    @Override
    public boolean isTreasure() {
        return isTreasure;
    }
    @Override
    public boolean isCursed() {
        return isCursed;
    }
    @Override
    public boolean conflictsWith(Enchantment other) {
        return false;
    }
    @Override
    public boolean canEnchantItem(ItemStack item) {
        return false;
    }
}
