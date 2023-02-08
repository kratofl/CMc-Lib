package kratofl.cmclib.advancements;

public class CustomAdvancementBuilder {

    private CustomAdvancement customAdvancement;

    public CustomAdvancementBuilder(CustomAdvancement customAdvancement) {
        this.customAdvancement = customAdvancement;
    }

    public CustomAdvancement build() {
        return this.customAdvancement;
    }

}
