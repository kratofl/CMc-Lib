package kratofl.cmclib.items;

import org.bukkit.inventory.ItemStack;

public class CustomItem {

    public CustomItem(ItemStack item, int id, boolean listenerImplemented) {
        this.item = item;
        this.id = id;
        this.listenerImplemented = listenerImplemented;
    }

    private ItemStack item;
    public ItemStack getItem(int amount) {
        this.item.setAmount(amount);
        return this.item;
    }

    private final int id;
    public int getId() {
        return this.id;
    }

    private boolean listenerImplemented;
    public boolean listenerImplemented() {
        return this.listenerImplemented;
    }
}
