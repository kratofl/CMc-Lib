package kratofl.cmclib.advancements.objs;

import com.google.gson.annotations.Expose;
import kratofl.cmclib.advancements.trigger.AdvancementTriggerable;

public class Criteria {

    private String name;

    @Expose
    private String trigger;
    @Expose
    private AdvancementTriggerable conditions;

    public Criteria(String name, AdvancementTriggerable condition) {
        this.name = name;
        this.trigger = condition.getTriggerType();
        this.conditions = condition;
    }

    public String getName() {
        return this.name;
    }
}
