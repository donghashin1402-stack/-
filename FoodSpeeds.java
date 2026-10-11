package com.dongha.fasteat;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Set;

public final class FoodSpeeds {
    public static final float ONE_TICK = 1.0F / 20.0F;
    public static final float THREE_TICKS = 3.0F / 20.0F;
    public static final float FOUR_TICKS = 4.0F / 20.0F;
    public static final float TEN_TICKS = 10.0F / 20.0F;

    private static final Set<String> FAST_FOOD = Set.of(
            "minecraft:beef", "minecraft:cooked_beef",
            "minecraft:porkchop", "minecraft:cooked_porkchop",
            "minecraft:chicken", "minecraft:cooked_chicken",
            "minecraft:mutton", "minecraft:cooked_mutton",
            "minecraft:rabbit", "minecraft:cooked_rabbit",
            "minecraft:cod", "minecraft:cooked_cod",
            "minecraft:salmon", "minecraft:cooked_salmon",
            "minecraft:tropical_fish",

            "minecraft:mushroom_stew", "minecraft:suspicious_stew",
            "minecraft:rabbit_stew", "minecraft:beetroot_soup",

            "minecraft:bread", "minecraft:cookie", "minecraft:cake",
            "minecraft:potato", "minecraft:baked_potato",
            "minecraft:carrot", "minecraft:golden_carrot",
            "minecraft:beetroot",
            "minecraft:apple", "minecraft:golden_apple",
            "minecraft:melon_slice", "minecraft:glistering_melon_slice",
            "minecraft:glow_berries", "minecraft:sweet_berries",
            "minecraft:chorus_fruit", "minecraft:dried_kelp",
            "minecraft:honey_bottle"
    );

    private static final Set<String> DEBUFF_FOOD = Set.of(
            "minecraft:spider_eye",
            "minecraft:rotten_flesh",
            "minecraft:pufferfish",
            "minecraft:poisonous_potato"
    );

    private FoodSpeeds() {}

    public static float getConsumeSeconds(ItemStack stack, float originalSeconds) {
        Item item = stack.getItem();
        String id = BuiltInRegistries.ITEM.getKey(item).toString();

        if (id.equals("minecraft:potion")
                || id.equals("minecraft:splash_potion")
                || id.equals("minecraft:lingering_potion")) {
            return THREE_TICKS;
        }

        if (id.equals("minecraft:enchanted_golden_apple")) {
            return TEN_TICKS;
        }

        if (DEBUFF_FOOD.contains(id)) {
            return FOUR_TICKS;
        }

        if (FAST_FOOD.contains(id)) {
            return ONE_TICK;
        }

        return originalSeconds;
    }
}
