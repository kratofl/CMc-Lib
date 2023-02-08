package kratofl.cmclib.crafting;

import org.bukkit.inventory.CraftingInventory;

import java.util.ArrayList;
public class CustomCraftingRecipes {

    private static ArrayList<CustomCraftingRecipe> customCraftingRecipes = new ArrayList<>();

    public static void addCustomCraftingRecipe(CustomCraftingRecipe recipe) {
        customCraftingRecipes.add(recipe);
    }

    public static void checkIfRecipeIsCustom(CraftingInventory craftingTableInv) {
        for (CustomCraftingRecipe customCraftingRecipe: customCraftingRecipes) {
            customCraftingRecipe.checkTable(craftingTableInv);
        }
    }
}
