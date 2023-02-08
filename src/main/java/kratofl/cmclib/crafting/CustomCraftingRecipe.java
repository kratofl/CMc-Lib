package kratofl.cmclib.crafting;

import org.bukkit.Material;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class CustomCraftingRecipe {

    CustomCraftingRecipe(CustomCraftingRecipeBuilder builder) {
        this.ingredients = builder.ingredients;
        this.result = builder.result;
    }

    private HashMap<Integer, ItemStack> ingredients = new HashMap<Integer, ItemStack>();
    private ItemStack result = new ItemStack(Material.STONE);

    //private CustomCraftingRecipeBuilder builder;

    public boolean checkTable(CraftingInventory inv) {
        ItemStack[] matrix = inv.getMatrix();

        for (int i = 0; i < 9; i++) {
            if (this.ingredients.containsKey(i)) {
                if (matrix[i] == null || !matrix[i].equals(this.ingredients.get(i)))
                    return false;
            } else if (matrix[i] != null)
                return false;
        }

        inv.setResult(this.result);
        return true;
    }

    public class CustomCraftingRecipeBuilder {

        private HashMap<Integer, ItemStack> ingredients = new HashMap<Integer, ItemStack>();
        private ItemStack result;

        CustomCraftingRecipeBuilder(ItemStack result) {
            this.result = result;
        }

        /**
         * @param tableIdx [0-9]
         * @param item
         */
        public CustomCraftingRecipeBuilder addIngredient(int tableIdx, ItemStack item) {
            this.ingredients.put(tableIdx, item);
            return this;
        }

        public CustomCraftingRecipe build() {
            CustomCraftingRecipe recipe = new CustomCraftingRecipe(this);
            CustomCraftingRecipes.addCustomCraftingRecipe(recipe);
            return recipe;
        }
    }
}
