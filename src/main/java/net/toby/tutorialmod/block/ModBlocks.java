package net.toby.tutorialmod.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.toby.tutorialmod.TutorialMod;

public class ModBlocks {
    public static final Block VIBRANIUM_CORE_BLOCK = registerBlock("vibranium_core_block",
            new Block(AbstractBlock.Settings.create().
                    strength(1.5F).
                    requiresTool().
                    sounds(BlockSoundGroup.NETHERITE).
                    luminance(state -> 5)
                    .emissiveLighting(Blocks::always)
            ));

    public static final Block VIBRANIUM_BLOB_BLOCK = registerBlock("vibranium_blob_block",
            new Block(AbstractBlock.Settings.create().
                    strength(0.7F).
                    requiresTool().
                    sounds(BlockSoundGroup.ANCIENT_DEBRIS).
                    luminance(state -> 1)
                    .emissiveLighting(Blocks::always)
            ));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        TutorialMod.LOGGER.info("Registering Mod Blocks for " + TutorialMod.MOD_ID);
    }
}
