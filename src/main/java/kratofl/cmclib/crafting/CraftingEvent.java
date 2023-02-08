package kratofl.cmclib.crafting;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;

public class CraftingEvent implements Listener {

    @EventHandler
    public void onPlayerCraftItem(PrepareItemCraftEvent e)
    {
        if (e.getInventory().getMatrix().length < 9) { return; }
        CustomCraftingRecipes.checkIfRecipeIsCustom(e.getInventory());

        Bukkit.getServer().addRecipe(new FurnaceRecipe(NamespacedKey.minecraft("newRecipe"), new ItemStack(Material.LEATHER), new RecipeChoice.ExactChoice(new ItemStack(Material.ROTTEN_FLESH)), 100, 60 * 20));
    }
}
