package kratofl.cmclib.advancements.constants;

public enum TriggerType {
    ALLAY_DROP_ITEM_ON_BLOCK("minecraft:allay_drop_item_on_block"),
    AVOID_VIBRATION("minecraft:avoid_vibration"),
    BEE_NEST_DESTROYED("minecraft:bee_nest_destroyed"),
    BRED_ANIMALS("minecraft:bred_animals"),
    BREWED_POTION("minecraft:brewed_potion"),
    CHANGED_DIMENSION("minecraft:changed_dimension"),
    CHANNELED_LIGHTNING("minecraft:channeled_lightning"),
//    AVOID_VIBRATION("minecraft:construct_beacon"),
//    AVOID_VIBRATION("minecraft:consume_item"),
//    AVOID_VIBRATION("minecraft:cured_zombie_villager"),
//    AVOID_VIBRATION("minecraft:effects_changed"),
//    AVOID_VIBRATION("minecraft:enchanted_item"),
//    AVOID_VIBRATION("minecraft:enter_block"),
//    AVOID_VIBRATION("minecraft:entity_hurt_player"),
//    AVOID_VIBRATION("minecraft:entity_killed_player"),
//    AVOID_VIBRATION("minecraft:fall_from_height"),
//    AVOID_VIBRATION("minecraft:filled_bucket"),
//    AVOID_VIBRATION("minecraft:hero_of_the_village"),
    IMPOSSIBLE("minecraft:impossible"),
    INVENTORY_CHANGED("minecraft:inventory_changed"),
//    AVOID_VIBRATION("minecraft:item_durability_changed"),
//    AVOID_VIBRATION("minecraft:item_used_on_block"),
//    AVOID_VIBRATION("minecraft:kill_mob_near_sculk_catalyst"),
//    AVOID_VIBRATION("minecraft:killed_by_crossbow"),
//    AVOID_VIBRATION("minecraft:levitation"),
//    AVOID_VIBRATION("minecraft:lightning_strike"),
//    AVOID_VIBRATION("minecraft:location"),
//    AVOID_VIBRATION("minecraft:nether_travel"),
//    AVOID_VIBRATION("minecraft:placed_block"),
//    AVOID_VIBRATION("minecraft:player_generates_container_loot"),
//    AVOID_VIBRATION("minecraft:player_hurt_entity"),
//    AVOID_VIBRATION("minecraft:player_interacted_with_entity"),
//    AVOID_VIBRATION("minecraft:player_killed_entity"),
//    AVOID_VIBRATION("minecraft:recipe_unlocked"),
//    AVOID_VIBRATION("minecraft:ride_entity_in_lava"),
//    AVOID_VIBRATION("minecraft:shot_crossbow"),
//    AVOID_VIBRATION("minecraft:slept_in_bed"),
//    AVOID_VIBRATION("minecraft:slide_down_block"),
//    AVOID_VIBRATION("minecraft:started_riding"),
//    AVOID_VIBRATION("minecraft:summoned_entity"),
//    AVOID_VIBRATION("minecraft:minecraft:tame_animal"),
//    AVOID_VIBRATION("minecraft:target_hit"),
//    AVOID_VIBRATION("minecraft:thrown_item_picked_up_by_entity"),
//    AVOID_VIBRATION("minecraft:thrown_item_picked_up_by_player"),
//    AVOID_VIBRATION("minecraft:tick"),
//    AVOID_VIBRATION("minecraft:used_ender_eye"),
//    AVOID_VIBRATION("minecraft:used_totem"),
//    AVOID_VIBRATION("minecraft:using_item"),
//    AVOID_VIBRATION("minecraft:villager_trade"),
    VOLUNTARY_EXILE("minecraft:voluntary_exile");

    private final String name;

    TriggerType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
