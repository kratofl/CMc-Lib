package kratofl.cmclib.recipes.crafting;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;

public class CustomShapedCraftingRecipe implements ICustomCraftingRecipe {

    private final NamespacedKey namespacedKey;
    private final ItemStack result;
    private final String[] shape;
    private final HashMap<Character, ItemStack> ingredients = new HashMap<>();

    public CustomShapedCraftingRecipe(Plugin plugin, String namespaceKey, String[] shape, ItemStack result) {
        if (shape.length != 3)
            throw new IllegalArgumentException("Parameter 'shape' must contain exact3  rows");

        this.shape = shape;
        this.result = result;
        this.namespacedKey = new NamespacedKey(plugin, namespaceKey);
    }

    public CustomShapedCraftingRecipe setIngredient(Character key, ItemStack ingredient) {
        this.ingredients.put(key, ingredient);
        return this;
    }

    @Override
    public void register() {
        ShapedRecipe shapedRecipe = new ShapedRecipe(this.namespacedKey, this.result);
        shapedRecipe.shape(shape[0], shape[1], shape[2]);
        for (HashMap.Entry<Character, ItemStack> ingredient : this.ingredients.entrySet()) {
            shapedRecipe.setIngredient(ingredient.getKey(), new RecipeChoice.ExactChoice(ingredient.getValue()));
        }
        Bukkit.getServer().addRecipe(shapedRecipe);
    }
}