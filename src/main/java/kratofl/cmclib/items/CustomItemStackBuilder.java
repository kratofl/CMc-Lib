package kratofl.cmclib.items;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

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

    private NamespacedKey durabilityKey;
    private NamespacedKey maxDurabilityKey;
    public CustomItemStackBuilder setDurability(int durability) {
        itemMeta.getPersistentDataContainer().set(durabilityKey, PersistentDataType.INTEGER, durability);
        itemMeta.getPersistentDataContainer().set(maxDurabilityKey, PersistentDataType.INTEGER, durability);
        return this;
    }
    public CustomItemStackBuilder addEnchantments(HashMap<Enchantment, Integer> enchantments) {
        for (Map.Entry<Enchantment, Integer> enchantment : enchantments.entrySet()) {
            itemMeta.addEnchant(enchantment.getKey(), enchantment.getValue(), true);
        }
        return this;
    }
    public CustomItemStackBuilder addLores(List<String> lores) {
        itemMeta.setLore(lores);
        return this;
    }

    public ItemStack build() {
        item.setItemMeta(itemMeta);
        return item;
    }
}
