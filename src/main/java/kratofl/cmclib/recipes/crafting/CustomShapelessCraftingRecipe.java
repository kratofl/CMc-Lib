package kratofl.cmclib.recipes.crafting;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CustomShapelessCraftingRecipe implements ICustomCraftingRecipe {

    private final NamespacedKey namespacedKey;
    private final ItemStack result;
    private final ArrayList<ItemStack> ingredients = new ArrayList<>();

    public CustomShapelessCraftingRecipe(Plugin plugin, String namespaceKey, ItemStack result) {
        this.namespacedKey = new NamespacedKey(plugin, namespaceKey);
        this.result = result;
    }

    public CustomShapelessCraftingRecipe addIngredient(ItemStack ingredient) {
        this.ingredients.add(ingredient);
        return this;
    }

    @Override
    public void register() {
        ShapelessRecipe shapelessRecipe = new ShapelessRecipe(this.namespacedKey, this.result);
        for (ItemStack ingredient : this.ingredients) {
            shapelessRecipe.addIngredient(new RecipeChoice.ExactChoice(ingredient));
        }
        Bukkit.getServer().addRecipe(shapelessRecipe);
    }
}