package kratofl.cmclib.recipes.furnace;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.plugin.Plugin;

public class CustomFurnaceRecipe {

    /**
     * @param plugin
     * @param namespaceKey
     * @param recipeChoice
     * @param result
     * @param xp
     * @param cookingTime  in seconds
     */
    public static void addNewRecipe(Plugin plugin, String namespaceKey, ItemStack recipeChoice, ItemStack result, int xp, int cookingTime) {
        Bukkit.getServer().addRecipe(
                new FurnaceRecipe(new NamespacedKey(plugin, namespaceKey),
                        result,
                        new RecipeChoice.ExactChoice(recipeChoice),
                        xp,
                        cookingTime * 20));
    }
}
