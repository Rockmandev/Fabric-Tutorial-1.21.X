package net.toby.tutorialmod.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.toby.tutorialmod.TutorialMod;
import net.toby.tutorialmod.block.custom.MagicBlock;

public class ModBlocks {
    public static final Block VIBRANIUM_CORE_BLOCK = registerBlock("vibranium_core_block",
            new Block(AbstractBlock.Settings.create().
                    strength(3F).
                    requiresTool().
                    sounds(BlockSoundGroup.NETHERITE).
                    luminance(state -> 5)
                    .emissiveLighting(Blocks::always)
            ));

    public static final Block VIBRANIUM_BLOB_BLOCK = registerBlock("vibranium_blob_block",
            new Block(AbstractBlock.Settings.create().
                    strength(4F).
                    requiresTool().
                    sounds(BlockSoundGroup.ANCIENT_DEBRIS).
                    luminance(state -> 1)
                    .emissiveLighting(Blocks::always)
            ));

    public static final Block VIBRANIUM_ORE_BLOCK = registerBlock("vibranium_ore_block",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5),
                    AbstractBlock.Settings.create().
                    strength(3F, 9F).
                    requiresTool().
                    sounds(BlockSoundGroup.STONE)
            ));

    public static final MagicBlock MAGIC_BLOCK = (MagicBlock) registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create().
                    strength(5F, 100F).
                    sounds(BlockSoundGroup.LODESTONE)));

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
