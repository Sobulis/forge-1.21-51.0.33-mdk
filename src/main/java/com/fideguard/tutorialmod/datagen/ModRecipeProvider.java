package com.fideguard.tutorialmod.datagen;

import com.fideguard.tutorialmod.TutorialMod;
import com.fideguard.tutorialmod.block.ModBlocks;
import com.fideguard.tutorialmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.awt.*;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> ALEXANDRITE_SMELTABLES = List.of(ModItems.RAW_ALEXANDRITE.get(),
                ModBlocks.ALEXANDRITE_ORE.get(), ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get());

        List<ItemLike> EMBERNITE_SMELTABLES = List.of(ModItems.RAW_EMBERNITE.get(),
                ModBlocks.EMBERNITE_ORE.get(), ModBlocks.EMBERNITE_DEEPSLATE_ORE.get());

        List<ItemLike> ZEPHRYTE_SMELTABLES = List.of(ModItems.RAW_ZEPHRYTE.get(),
                ModBlocks.ZEPHRYTE_ORE.get(), ModBlocks.ZEPHRYTE_DEEPSLATE_ORE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ALEXANDRITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ALEXANDRITE.get())
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AURORA_ASHES.get(), 4)
                .pattern(" A ")
                .pattern("A A")
                .pattern(" A ")
                .define('A', ModItems.ZEPHRYTE.get())
                .unlockedBy(getHasName(ModItems.ZEPHRYTE.get()), has(ModItems.ZEPHRYTE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BOUNCE_BALL.get(), 2)
                .pattern("AAA")
                .pattern("AXA")
                .pattern("AAA")
                .define('A', ModItems.ZEPHRYTE_NUGGET.get())
                .define('X', Items.SLIME_BALL)
                .unlockedBy(getHasName(ModItems.ZEPHRYTE.get()), has(ModItems.ZEPHRYTE_NUGGET.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BOUNCE_BLOCK.get())
                .pattern("AA")
                .pattern("AA")
                .define('A', ModItems.BOUNCE_BALL.get())
                .unlockedBy(getHasName(ModItems.BOUNCE_BALL.get()), has(ModItems.BOUNCE_BALL.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CHARRED_STICK.get(), 8)
                .pattern(" A ")
                .pattern(" A ")
                .define('A', ItemTags.SAPLINGS)
                .unlockedBy("has_sapling",has(ItemTags.SAPLINGS)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CHISEL.get())
                .pattern(" A ")
                .pattern(" X ")
                .pattern(" X ")
                .define('A', ModItems.ALEXANDRITE.get())
                .define('X', Items.STICK)
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.EMBERNITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.EMBERNITE.get())
                .unlockedBy(getHasName(ModItems.EMBERNITE.get()), has(ModItems.EMBERNITE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MAGIC_BLOCK.get())
                .pattern("AX")
                .pattern("XA")
                .define('A', ModItems.RAW_EMBERNITE.get())
                .define('X', ModItems.RAW_ZEPHRYTE.get())
                .unlockedBy(getHasName(ModItems.RAW_EMBERNITE.get()), has(ModItems.RAW_EMBERNITE.get()))
                .unlockedBy(getHasName(ModItems.RAW_ZEPHRYTE.get()), has(ModItems.RAW_ZEPHRYTE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_ALEXANDRITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.RAW_ALEXANDRITE.get())
                .unlockedBy(getHasName(ModItems.RAW_ALEXANDRITE.get()), has(ModItems.RAW_ALEXANDRITE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_EMBERNITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.RAW_EMBERNITE.get())
                .unlockedBy(getHasName(ModItems.RAW_EMBERNITE.get()), has(ModItems.RAW_EMBERNITE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_ZEPHRYTE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.RAW_ZEPHRYTE.get())
                .unlockedBy(getHasName(ModItems.RAW_ZEPHRYTE.get()), has(ModItems.RAW_ZEPHRYTE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SMELT_TORCH.get())
                .pattern(" A ")
                .pattern(" X ")
                .pattern(" A ")
                .define('A', ModItems.EMBERNITE.get())
                .define('X', Items.STICK)
                .unlockedBy(getHasName(ModItems.EMBERNITE.get()), has(ModItems.EMBERNITE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ZEPHRYTE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ZEPHRYTE.get())
                .unlockedBy(getHasName(ModItems.ZEPHRYTE.get()), has(ModItems.ZEPHRYTE.get()))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ZEPHRYTE.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ZEPHRYTE_NUGGET.get())
                .unlockedBy(getHasName(ModItems.ZEPHRYTE_NUGGET.get()), has(ModItems.ZEPHRYTE_NUGGET.get()))
                .save(pRecipeOutput, TutorialMod.MOD_ID + ":zephryte_from_nugget");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 9)
                .requires(ModBlocks.ALEXANDRITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ALEXANDRITE_BLOCK.get()), has(ModBlocks.ALEXANDRITE_BLOCK.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.EMBERNITE.get(),9)
                .requires(ModBlocks.EMBERNITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.EMBERNITE_BLOCK.get()), has(ModBlocks.EMBERNITE_BLOCK.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 32)
                .requires(ModBlocks.MAGIC_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ALEXANDRITE_BLOCK.get()), has(ModBlocks.ALEXANDRITE_BLOCK.get()))
                .save(pRecipeOutput, TutorialMod.MOD_ID + ":alexandrite_from_magic_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_ALEXANDRITE.get(), 9)
                .requires(ModBlocks.RAW_ALEXANDRITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_ALEXANDRITE_BLOCK.get()), has(ModBlocks.RAW_ALEXANDRITE_BLOCK.get()))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_EMBERNITE.get(), 9)
                .requires(ModBlocks.RAW_EMBERNITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_EMBERNITE_BLOCK.get()), has(ModBlocks.RAW_EMBERNITE_BLOCK.get()))
                .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_ZEPHRYTE.get(), 9)
                    .requires(ModBlocks.RAW_ZEPHRYTE_BLOCK.get())
                    .unlockedBy(getHasName(ModBlocks.RAW_ZEPHRYTE_BLOCK.get()), has(ModBlocks.RAW_ZEPHRYTE_BLOCK.get()))
                    .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ZEPHRYTE.get(), 9)
                    .requires(ModBlocks.ZEPHRYTE_BLOCK.get())
                    .unlockedBy(getHasName(ModBlocks.ZEPHRYTE_BLOCK.get()), has(ModBlocks.ZEPHRYTE_BLOCK.get()))
                    .save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ZEPHRYTE_NUGGET.get(), 9)
                    .requires(ModItems.ZEPHRYTE.get())
                    .unlockedBy(getHasName(ModItems.ZEPHRYTE.get()), has(ModItems.ZEPHRYTE.get()))
                    .save(pRecipeOutput);

        oreSmelting(pRecipeOutput, ALEXANDRITE_SMELTABLES, RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 0.25f, 200, "alexandrite");
        oreBlasting(pRecipeOutput, ALEXANDRITE_SMELTABLES, RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 0.25f, 100, "alexandrite");

        oreSmelting(pRecipeOutput, EMBERNITE_SMELTABLES, RecipeCategory.MISC, ModItems.EMBERNITE.get(), 0.25f, 200, "embernite");
        oreBlasting(pRecipeOutput, EMBERNITE_SMELTABLES, RecipeCategory.MISC, ModItems.EMBERNITE.get(), 0.25f, 100, "embernite");

        oreSmelting(pRecipeOutput, ZEPHRYTE_SMELTABLES, RecipeCategory.MISC, ModItems.ZEPHRYTE.get(), 0.25f, 200, "zephryte");
        oreBlasting(pRecipeOutput, ZEPHRYTE_SMELTABLES, RecipeCategory.MISC, ModItems.ZEPHRYTE.get(), 0.25f, 100, "zephryte");


        stairBuilder(ModBlocks.ALEXANDRITE_STAIRS.get(), Ingredient.of(ModItems.ALEXANDRITE.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ALEXANDRITE_SLAB.get(), ModItems.ALEXANDRITE.get());

        buttonBuilder(ModBlocks.ALEXANDRITE_BUTTON.get(), Ingredient.of(ModItems.ALEXANDRITE.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);
        pressurePlate(pRecipeOutput, ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get(), ModItems.ALEXANDRITE.get());

        fenceBuilder(ModBlocks.ALEXANDRITE_FENCE.get(), Ingredient.of(ModItems.ALEXANDRITE.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);
        fenceGateBuilder(ModBlocks.ALEXANDRITE_FENCE_GATE.get(), Ingredient.of(ModItems.ALEXANDRITE.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ALEXANDRITE_WALL.get(), ModItems.ALEXANDRITE.get());

        doorBuilder(ModBlocks.ALEXANDRITE_DOOR.get(), Ingredient.of(ModItems.ALEXANDRITE.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);
        trapdoorBuilder(ModBlocks.ALEXANDRITE_TRAPDOOR.get(), Ingredient.of(ModItems.ALEXANDRITE.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get())).save(pRecipeOutput);

    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, TutorialMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
