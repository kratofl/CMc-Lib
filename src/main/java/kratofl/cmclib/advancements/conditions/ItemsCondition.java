package kratofl.cmclib.advancements.conditions;

import com.google.gson.annotations.Expose;
import org.bukkit.Material;

import java.util.ArrayList;

public class ItemsCondition {

    @Expose
    private int count = 1;
    @Expose
    private ArrayList<String> items;
    @Expose
    private String nbt;

    public ItemsCondition addItem(Material itemMaterial) {
        this.items.add(itemMaterial.toString());
        return this;
    }

    public ItemsCondition setCount(int count) {
        this.count = count;
        return this;
    }

    public ItemsCondition setNBT(String nbt) {
        this.nbt = nbt;
        return this;
    }
}
