package kratofl.cmclib.recipes.crafting;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomShapedCraftingRecipe {
    public CustomShapedCraftingRecipe(CustomShapedCraftingRecipeBuilder builder) {
        this.namespacedKey = builder.namespacedKey;
        this.result = builder.result;
        this.ingredients = builder.ingredients;
        this.shape = builder.shape;
    }

    private final NamespacedKey namespacedKey;
    private final ItemStack result;

    private final HashMap<Character, ItemStack> ingredients;

    private final String[] shape;

    public void add() {
        ShapedRecipe shapedRecipe = new ShapedRecipe(this.namespacedKey, this.result);
        shapedRecipe.shape(shape[0], shape[1], shape[2]);
        for (HashMap.Entry<Character, ItemStack> ingredient : this.ingredients.entrySet()) {
            shapedRecipe.setIngredient(ingredient.getKey(), new RecipeChoice.ExactChoice(ingredient.getValue()));
        }
        Bukkit.getServer().addRecipe(shapedRecipe);
    }

    public static class CustomShapedCraftingRecipeBuilder {
        private NamespacedKey namespacedKey;
        private ItemStack result;

        private HashMap<Character, ItemStack> ingredients = new HashMap<>();

        private String[] shape = new String[3];

        public CustomShapedCraftingRecipeBuilder setNamespacedKey(NamespacedKey namespacedKey) {
            this.namespacedKey = namespacedKey;
            return this;
        }

        public CustomShapedCraftingRecipeBuilder setResult(ItemStack result) {
            this.result = result;
            return this;
        }

        public CustomShapedCraftingRecipeBuilder setShape(String firstRow, String secondRow, String thirdRow) {
            this.shape[0] = firstRow;
            this.shape[1] = secondRow;
            this.shape[2] = thirdRow;
            return this;
        }

        public CustomShapedCraftingRecipeBuilder addIngredient(Character key, ItemStack ingredient) {
            this.ingredients.put(key, ingredient);
            return this;
        }

        public CustomShapedCraftingRecipeBuilder addIngredient(Character key, Material ingredient) {
            this.ingredients.put(key, new ItemStack(ingredient));
            return this;
        }

        public CustomShapedCraftingRecipe build() {
            return new CustomShapedCraftingRecipe(this);
        }
    }
}
