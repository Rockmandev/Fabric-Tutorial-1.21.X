package net.toby.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.toby.tutorialmod.TutorialMod;
import net.toby.tutorialmod.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup MAGIC_METAL_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "magic_metal_group"),
            FabricItemGroup.builder().
                    icon(() -> new ItemStack(ModItems.VIBRANIUM_ROD)).displayName(Text.translatable("itemgroup.tutorialmod.magic_metal_group")).
                    entries((displayContext, entries) -> {
                        entries.add(ModItems.IMPURE_VIBRANIUM);
                        entries.add(ModItems.VIBRANIUM_ROD);
                        entries.add(ModItems.VIBRANIUM_SHARD);

                        entries.add(ModBlocks.VIBRANIUM_BLOB_BLOCK);
                        entries.add(ModBlocks.VIBRANIUM_CORE_BLOCK);
                        entries.add(ModBlocks.VIBRANIUM_ORE_BLOCK);

                        entries.add(ModItems.IRON_CHISEL);
                        entries.add(ModItems.BOOM_STICK);

                        entries.add(ModItems.HEART);
                        entries.add(ModItems.STEEL_WOOL);
                        entries.add(ModItems.GRAPES);

                        entries.add(ModBlocks.MAGIC_BLOCK);
                    }).
                    build());

    public static void registerItemGroups() {
        TutorialMod.LOGGER.info("Registering Item Groups for " + TutorialMod.MOD_ID);
    }
}
