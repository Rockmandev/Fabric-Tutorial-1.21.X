package net.toby.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.toby.tutorialmod.TutorialMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item VIBRANIUM_ROD = registerItem("vibranium_rod", new Item(new Item.Settings()));
    public static final Item IMPURE_VIBRANIUM = registerItem("impure_vibranium", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);
    }
}
