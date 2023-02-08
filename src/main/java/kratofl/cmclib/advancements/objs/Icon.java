package kratofl.cmclib.advancements.objs;

import com.google.gson.annotations.Expose;
import org.bukkit.Material;

public class Icon {
    @Expose
    private String item;
    @Expose
    private String nbt;

    Icon(Material material) {
        this.item = material.getKey().toString();
    }

    public void SetNbt(String nbt) {
        this.nbt = nbt;
    }
}
