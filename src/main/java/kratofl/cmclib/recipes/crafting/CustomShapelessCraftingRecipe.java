package kratofl.cmclib.recipes.crafting;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;

import java.util.ArrayList;

public class CustomShapelessCraftingRecipe {

    public CustomShapelessCraftingRecipe(CustomShapelessCraftingRecipe.CustomShapelessCraftingRecipeBuilder builder) {
        this.namespacedKey = builder.namespacedKey;
        this.result = builder.result;
        this.ingredients = builder.ingredients;
        this.shape = builder.shape;
    }

    private final NamespacedKey namespacedKey;
    private final ItemStack result;

    private final ArrayList<ItemStack> ingredients;

    private final String[] shape;

    public void add() {
        ShapelessRecipe shapelessRecipe = new ShapelessRecipe(this.namespacedKey, this.result);
        for (ItemStack ingredient : this.ingredients) {
            shapelessRecipe.addIngredient(new RecipeChoice.ExactChoice(ingredient));
        }
        Bukkit.getServer().addRecipe(shapelessRecipe);
    }

    public static class CustomShapelessCraftingRecipeBuilder {
        private NamespacedKey namespacedKey;
        private ItemStack result;

        private ArrayList<ItemStack> ingredients = new ArrayList<>();

        private String[] shape = new String[3];

        public CustomShapelessCraftingRecipeBuilder setNamespacedKey(NamespacedKey namespacedKey) {
            this.namespacedKey = namespacedKey;
            return this;
        }

        public CustomShapelessCraftingRecipeBuilder setResult(ItemStack result) {
            this.result = result;
            return this;
        }

        public CustomShapelessCraftingRecipeBuilder addIngredient(ItemStack ingredient) {
            this.ingredients.add(ingredient);
            return this;
        }

        public CustomShapelessCraftingRecipeBuilder addIngredient(Material ingredient, int amount) {
            this.ingredients.add(new ItemStack(ingredient, amount));
            return this;
        }

        public CustomShapelessCraftingRecipe build() {
            return new CustomShapelessCraftingRecipe(this);
        }
    }
}