package net.toby.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.toby.tutorialmod.TutorialMod;
import net.toby.tutorialmod.block.ModBlocks;
import net.toby.tutorialmod.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {

        List<ItemConvertible> VIBRANIUM_SHARD_SMELTABLES = List.of(ModItems.IMPURE_VIBRANIUM, ModBlocks.VIBRANIUM_ORE_BLOCK);

        offerBlasting(recipeExporter, VIBRANIUM_SHARD_SMELTABLES, RecipeCategory.MISC, ModItems.VIBRANIUM_SHARD, 0.5f, 400, "vibrainium_shard");

        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.IMPURE_VIBRANIUM, RecipeCategory.DECORATIONS, ModBlocks.VIBRANIUM_BLOB_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BOOM_STICK)
                .pattern("  V")
                .pattern(" S ")
                .pattern("S  ")
                .input('S', Items.STICK)
                .input('V', ModItems.VIBRANIUM_SHARD)
                .criterion(hasItem(ModItems.VIBRANIUM_SHARD), conditionsFromItem(ModItems.VIBRANIUM_SHARD))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.IMPURE_VIBRANIUM, 9)
                .input(ModBlocks.VIBRANIUM_BLOB_BLOCK)
                .criterion(hasItem(ModBlocks.VIBRANIUM_BLOB_BLOCK), conditionsFromItem(ModBlocks.VIBRANIUM_BLOB_BLOCK))
                .offerTo(recipeExporter, Identifier.of(TutorialMod.MOD_ID, "impure_vibranium_from_vibranium_blob_block"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.IMPURE_VIBRANIUM, 32)
                .input(ModBlocks.MAGIC_BLOCK)
                .criterion(hasItem(ModBlocks.MAGIC_BLOCK), conditionsFromItem(ModBlocks.MAGIC_BLOCK))
                .offerTo(recipeExporter, Identifier.of(TutorialMod.MOD_ID, "impure_vibranium_from_magic_block"));
    }
}
