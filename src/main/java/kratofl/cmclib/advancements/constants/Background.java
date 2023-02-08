package kratofl.cmclib.advancements.constants;

public enum Background {

    ADVENTURE( "minecraft:textures/gui/advancements/backgrounds/adventure.png" ),
    END( "minecraft:textures/gui/advancements/backgrounds/end.png" ),
    HUSBANDRY( "minecraft:textures/gui/advancements/backgrounds/husbandry.png" ),
    NETHER( "minecraft:textures/gui/advancements/backgrounds/nether.png" ),
    STONE( "minecraft:textures/gui/advancements/backgrounds/stone.png" );

    private final String name;
    Background(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return this.name;
    }

}