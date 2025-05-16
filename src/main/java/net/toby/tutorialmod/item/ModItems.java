package net.toby.tutorialmod.item;

import net.toby.tutorialmod.TutorialMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.toby.tutorialmod.item.custom.BoomStickItem;
import net.toby.tutorialmod.item.custom.ChiselItem;

public class ModItems {
    public static final Item VIBRANIUM_ROD = registerItem("vibranium_rod", new Item(new Item.Settings()));
    public static final Item IMPURE_VIBRANIUM = registerItem("impure_vibranium", new Item(new Item.Settings()));
    public static final Item VIBRANIUM_SHARD = registerItem("vibranium_shard", new Item(new Item.Settings()));

    public static final Item IRON_CHISEL = registerItem("iron_chisel", new ChiselItem(new Item.Settings().maxDamage(64)));
    public static final Item BOOM_STICK = registerItem("boom_stick", new BoomStickItem(new Item.Settings()));

    public static final Item HEART = registerItem("heart", new Item(new Item.Settings().food(ModFoodComponents.HEART)));
    public static final Item STEEL_WOOL = registerItem("steel_wool", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);
    }
}
