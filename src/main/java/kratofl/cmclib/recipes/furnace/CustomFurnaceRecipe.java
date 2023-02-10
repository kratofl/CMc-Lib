package kratofl.cmclib.recipes.furnace;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;

public class CustomFurnaceRecipe {

    /**
     * @param namespaceKey
     * @param recipeChoice
     * @param result
     * @param xp
     * @param cookingTime in seconds
     */
    public static void addNewRecipe(String namespaceKey, ItemStack recipeChoice, ItemStack result, int xp, int cookingTime) {
        addNewRecipe(NamespacedKey.minecraft(namespaceKey), recipeChoice, result, xp, cookingTime);
    }

    /**
     * @param namespacedKey
     * @param recipeChoice
     * @param result
     * @param xp
     * @param cookingTime in seconds
     */
    public static void addNewRecipe(NamespacedKey namespacedKey, ItemStack recipeChoice, ItemStack result, int xp, int cookingTime) {
        Bukkit.getServer().addRecipe(
                new FurnaceRecipe(namespacedKey,
                        result,
                        new RecipeChoice.ExactChoice(recipeChoice),
                        xp,
                        cookingTime * 20));
    }
}
