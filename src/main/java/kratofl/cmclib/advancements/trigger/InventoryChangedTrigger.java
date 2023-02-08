package kratofl.cmclib.advancements.trigger;

import com.google.gson.annotations.Expose;
import kratofl.cmclib.advancements.conditions.ItemsCondition;
import kratofl.cmclib.advancements.constants.TriggerType;

import java.util.ArrayList;

public class InventoryChangedTrigger implements AdvancementTriggerable {

    @Expose
    private ArrayList<ItemsCondition> items;

    public InventoryChangedTrigger addItemsCondition(ItemsCondition itemsCondition) {
        this.items.add(itemsCondition);
        return this;
    }

    @Override
    public String getTriggerType() {
        return TriggerType.INVENTORY_CHANGED.toString();
    }
}
