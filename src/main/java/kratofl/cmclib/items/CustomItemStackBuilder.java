package kratofl.cmclib.items;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomItemStackBuilder {

    public CustomItemStackBuilder(Material material, int amount) {
        this.item = new ItemStack(material, amount);
        this.itemMeta = this.item.getItemMeta();
    }

    private ItemStack item;
    private ItemMeta itemMeta;

    public CustomItemStackBuilder setName(String name) {
        itemMeta.setDisplayName(name);
        return this;
    }
    public CustomItemStackBuilder setCustomModelData(int customModelData) {
        itemMeta.setCustomModelData(customModelData);
        return this;
    }
    public CustomItemStackBuilder setUnbreakable() {
        itemMeta.setUnbreakable(true);
        return this;
    }
    public CustomItemStackBuilder setDamage(int damage) {
        if (itemMeta instanceof Damageable){
            ((Damageable) itemMeta).setDamage(damage);
        }
        return this;
    }

//    private NamespacedKey durabilityKey = NamespacedKey.minecraft("durability");
//    private NamespacedKey maxDurabilityKey = NamespacedKey.minecraft("max_durability");
//    public CustomItemStackBuilder setDurability(int durability) {
//        itemMeta.getPersistentDataContainer().set(durabilityKey, PersistentDataType.INTEGER, durability);
//        itemMeta.getPersistentDataContainer().set(maxDurabilityKey, PersistentDataType.INTEGER, durability);
//        return this;
//    }
    public CustomItemStackBuilder addEnchantment(Enchantment enchantment, Integer value) {
        itemMeta.addEnchant(enchantment, value, true);
        return this;
    }
    public CustomItemStackBuilder setLore(List<String> lore) {
        itemMeta.setLore(lore);
        return this;
    }
    public CustomItemStackBuilder addItemFlags(ItemFlag... itemFlag) {
        itemMeta.addItemFlags(itemFlag);
        return this;
    }

    public ItemStack build() {
        item.setItemMeta(itemMeta);
        return item;
    }
}
