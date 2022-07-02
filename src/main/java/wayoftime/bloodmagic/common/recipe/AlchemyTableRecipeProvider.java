package wayoftime.bloodmagic.common.recipe;

import java.util.function.Consumer;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import wayoftime.bloodmagic.BloodMagic;
import wayoftime.bloodmagic.common.block.BloodMagicBlocks;
import wayoftime.bloodmagic.common.data.recipe.builder.AlchemyTableRecipeBuilder;
import wayoftime.bloodmagic.common.data.recipe.builder.FilterMergeAlchemyTableRecipeBuilder;
import wayoftime.bloodmagic.common.item.BloodMagicItems;
import wayoftime.bloodmagic.common.item.ItemLivingTome;
import wayoftime.bloodmagic.common.item.routing.ItemCompositeFilter;
import wayoftime.bloodmagic.common.item.routing.ItemStandardFilter;
import wayoftime.bloodmagic.common.tags.BloodMagicTags;
import wayoftime.bloodmagic.core.LivingArmorRegistrar;
import wayoftime.bloodmagic.core.living.LivingStatsDummy;

public class AlchemyTableRecipeProvider implements ISubRecipeProvider
{
	@Override
	public void addRecipes(Consumer<FinishedRecipe> consumer)
	{
		ItemStack waterbottleStack = PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER);

		String basePath = "alchemytable/";
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(Items.STRING, 4), 100, 100, 0).addIngredient(Ingredient.of(ItemTags.WOOL)).addIngredient(Ingredient.of(Items.FLINT)).build(consumer, BloodMagic.rl(basePath + "string"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(Items.FLINT, 2), 50, 20, 0).addIngredient(Ingredient.of(Items.GRAVEL)).addIngredient(Ingredient.of(Items.FLINT)).build(consumer, BloodMagic.rl(basePath + "flint_from_gravel"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(Items.LEATHER, 4), 100, 200, 1).addIngredient(Ingredient.of(Items.ROTTEN_FLESH)).addIngredient(Ingredient.of(Items.ROTTEN_FLESH)).addIngredient(Ingredient.of(Items.ROTTEN_FLESH)).addIngredient(Ingredient.of(Items.ROTTEN_FLESH)).addIngredient(Ingredient.of(Items.FLINT)).addIngredient(Ingredient.of(Items.WATER_BUCKET)).build(consumer, BloodMagic.rl(basePath + "leather_from_flesh"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.EXPLOSIVE_POWDER.get()), 500, 200, 1).addIngredient(Ingredient.of(Tags.Items.GUNPOWDER)).addIngredient(Ingredient.of(Tags.Items.GUNPOWDER)).addIngredient(Ingredient.of(BloodMagicTags.DUST_COAL)).build(consumer, BloodMagic.rl(basePath + "explosive_powder"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(Items.BREAD), 100, 100, 1).addIngredient(Ingredient.of(Tags.Items.CROPS_WHEAT)).addIngredient(Ingredient.of(Items.SUGAR)).build(consumer, BloodMagic.rl(basePath + "bread"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(Blocks.GRASS_BLOCK), 200, 200, 1).addIngredient(Ingredient.of(Items.DIRT)).addIngredient(Ingredient.of(Items.BONE_MEAL)).addIngredient(Ingredient.of(Items.WHEAT_SEEDS)).build(consumer, BloodMagic.rl(basePath + "grass_block"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(Items.CLAY_BALL, 2), 50, 100, 2).addIngredient(Ingredient.of(Tags.Items.SAND)).addIngredient(Ingredient.of(Tags.Items.SAND)).addIngredient(Ingredient.of(Items.WATER_BUCKET)).build(consumer, BloodMagic.rl(basePath + "clay_from_sand"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(Items.COBWEB), 50, 50, 1).addIngredient(Ingredient.of(Tags.Items.STRING)).addIngredient(Ingredient.of(Tags.Items.STRING)).addIngredient(Ingredient.of(Tags.Items.STRING)).build(consumer, BloodMagic.rl(basePath + "cobweb"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(Items.NETHER_WART), 50, 40, 1).addIngredient(Ingredient.of(Items.NETHER_WART_BLOCK)).build(consumer, BloodMagic.rl(basePath + "nether_wart_from_block"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(Items.GOLD_NUGGET, 9), 200, 100, 2).addIngredient(Ingredient.of(Items.GILDED_BLACKSTONE)).build(consumer, BloodMagic.rl(basePath + "gold_ore_from_gilded"));

		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(Items.GUNPOWDER, 3), 0, 100, 0).addIngredient(Ingredient.of(BloodMagicTags.DUST_SULFUR)).addIngredient(Ingredient.of(BloodMagicTags.DUST_SALTPETER)).addIngredient(Ingredient.of(ItemTags.COALS)).build(consumer, BloodMagic.rl(basePath + "gunpowder"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.PLANT_OIL.get()), 100, 100, 1).addIngredient(Ingredient.of(Tags.Items.CROPS_CARROT)).addIngredient(Ingredient.of(Tags.Items.CROPS_CARROT)).addIngredient(Ingredient.of(Tags.Items.CROPS_CARROT)).addIngredient(Ingredient.of(Items.BONE_MEAL)).build(consumer, BloodMagic.rl(basePath + "plantoil_from_carrots"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.PLANT_OIL.get()), 100, 100, 1).addIngredient(Ingredient.of(Tags.Items.CROPS_POTATO)).addIngredient(Ingredient.of(Tags.Items.CROPS_POTATO)).addIngredient(Ingredient.of(Items.BONE_MEAL)).build(consumer, BloodMagic.rl(basePath + "plantoil_from_taters"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.PLANT_OIL.get()), 100, 100, 1).addIngredient(Ingredient.of(Tags.Items.CROPS_WHEAT)).addIngredient(Ingredient.of(Tags.Items.CROPS_WHEAT)).addIngredient(Ingredient.of(Items.BONE_MEAL)).build(consumer, BloodMagic.rl(basePath + "plantoil_from_wheat"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.PLANT_OIL.get()), 100, 100, 1).addIngredient(Ingredient.of(Tags.Items.CROPS_BEETROOT)).addIngredient(Ingredient.of(Tags.Items.CROPS_BEETROOT)).addIngredient(Ingredient.of(Tags.Items.CROPS_BEETROOT)).addIngredient(Ingredient.of(Items.BONE_MEAL)).build(consumer, BloodMagic.rl(basePath + "plantoil_from_beets"));

		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.IRON_SAND.get(), 2), 400, 200, 1).addIngredient(Ingredient.of(Tags.Items.ORES_IRON)).addIngredient(Ingredient.of(BloodMagicTags.ARC_TOOL_CUTTINGFLUID)).build(consumer, BloodMagic.rl(basePath + "sand_iron"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.GOLD_SAND.get(), 2), 400, 200, 1).addIngredient(Ingredient.of(Tags.Items.ORES_GOLD)).addIngredient(Ingredient.of(BloodMagicTags.ARC_TOOL_CUTTINGFLUID)).build(consumer, BloodMagic.rl(basePath + "sand_gold"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.COAL_SAND.get(), 4), 400, 200, 1).addIngredient(Ingredient.of(Items.COAL)).addIngredient(Ingredient.of(Items.COAL)).addIngredient(Ingredient.of(Items.FLINT)).build(consumer, BloodMagic.rl(basePath + "sand_coal"));

		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.SULFUR.get(), 4), 200, 100, 0).addIngredient(Ingredient.of(Items.LAVA_BUCKET)).addIngredient(Ingredient.of(Tags.Items.COBBLESTONE)).build(consumer, BloodMagic.rl(basePath + "sulfur_from_lava"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.SULFUR.get(), 4), 1200, 100, 0).addIngredient(Ingredient.of(BloodMagicItems.LAVA_SIGIL.get())).addIngredient(Ingredient.of(Tags.Items.COBBLESTONE)).build(consumer, BloodMagic.rl(basePath + "sulfur_from_sigil"));

		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.BASIC_CUTTING_FLUID.get()), 1000, 200, 1).addIngredient(Ingredient.of(BloodMagicItems.PLANT_OIL.get())).addIngredient(Ingredient.of(Tags.Items.DUSTS_REDSTONE)).addIngredient(Ingredient.of(Tags.Items.GUNPOWDER)).addIngredient(Ingredient.of(Items.SUGAR)).addIngredient(Ingredient.of(BloodMagicTags.DUST_COAL)).addIngredient(Ingredient.of(waterbottleStack)).build(consumer, BloodMagic.rl(basePath + "basic_cutting_fluid"));

		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.SLATE_VIAL.get(), 8), 500, 200, 1).addIngredient(Ingredient.of(BloodMagicItems.SLATE.get())).addIngredient(Ingredient.of(Tags.Items.GLASS)).addIngredient(Ingredient.of(Tags.Items.GLASS)).addIngredient(Ingredient.of(Tags.Items.GLASS)).addIngredient(Ingredient.of(Tags.Items.GLASS)).addIngredient(Ingredient.of(Tags.Items.GLASS)).build(consumer, BloodMagic.rl(basePath + "slate_vial"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.FORTUNE_ANOINTMENT.get()), 500, 100, 1).addIngredient(Ingredient.of(BloodMagicItems.SLATE_VIAL.get())).addIngredient(Ingredient.of(Tags.Items.CROPS_NETHER_WART)).addIngredient(Ingredient.of(Tags.Items.DUSTS_REDSTONE)).addIngredient(Ingredient.of(BloodMagicTags.DUST_COAL)).build(consumer, BloodMagic.rl(basePath + "fortune_anointment"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.SILK_TOUCH_ANOINTMENT.get()), 500, 100, 1).addIngredient(Ingredient.of(BloodMagicItems.SLATE_VIAL.get())).addIngredient(Ingredient.of(Tags.Items.CROPS_NETHER_WART)).addIngredient(Ingredient.of(Items.COBWEB)).addIngredient(Ingredient.of(Tags.Items.NUGGETS_GOLD)).build(consumer, BloodMagic.rl(basePath + "silk_touch_anointment"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.MELEE_DAMAGE_ANOINTMENT.get()), 500, 100, 1).addIngredient(Ingredient.of(BloodMagicItems.SLATE_VIAL.get())).addIngredient(Ingredient.of(Tags.Items.CROPS_NETHER_WART)).addIngredient(Ingredient.of(Items.BLAZE_POWDER)).addIngredient(Ingredient.of(Tags.Items.GEMS_QUARTZ)).build(consumer, BloodMagic.rl(basePath + "melee_damage_anointment"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.HOLY_WATER_ANOINTMENT.get()), 500, 100, 1).addIngredient(Ingredient.of(BloodMagicItems.SLATE_VIAL.get())).addIngredient(Ingredient.of(Tags.Items.CROPS_NETHER_WART)).addIngredient(Ingredient.of(Items.GLISTERING_MELON_SLICE)).addIngredient(Ingredient.of(Tags.Items.GEMS_QUARTZ)).build(consumer, BloodMagic.rl(basePath + "holy_water_anointment"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.HIDDEN_KNOWLEDGE_ANOINTMENT.get()), 500, 100, 1).addIngredient(Ingredient.of(BloodMagicItems.SLATE_VIAL.get())).addIngredient(Ingredient.of(Tags.Items.CROPS_NETHER_WART)).addIngredient(Ingredient.of(Items.GLASS_BOTTLE)).addIngredient(Ingredient.of(Items.ENCHANTED_BOOK)).build(consumer, BloodMagic.rl(basePath + "hidden_knowledge_anointment"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.QUICK_DRAW_ANOINTMENT.get()), 500, 100, 1).addIngredient(Ingredient.of(BloodMagicItems.SLATE_VIAL.get())).addIngredient(Ingredient.of(Tags.Items.CROPS_NETHER_WART)).addIngredient(Ingredient.of(Tags.Items.STRING)).addIngredient(Ingredient.of(Items.SPECTRAL_ARROW)).build(consumer, BloodMagic.rl(basePath + "quick_draw_anointment"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.LOOTING_ANOINTMENT.get()), 500, 100, 1).addIngredient(Ingredient.of(BloodMagicItems.SLATE_VIAL.get())).addIngredient(Ingredient.of(Tags.Items.CROPS_NETHER_WART)).addIngredient(Ingredient.of(Tags.Items.GEMS_LAPIS)).addIngredient(Ingredient.of(Tags.Items.BONES)).build(consumer, BloodMagic.rl(basePath + "looting_anointment"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.BOW_POWER_ANOINTMENT.get()), 500, 100, 1).addIngredient(Ingredient.of(BloodMagicItems.SLATE_VIAL.get())).addIngredient(Ingredient.of(Tags.Items.CROPS_NETHER_WART)).addIngredient(Ingredient.of(Tags.Items.INGOTS_IRON)).addIngredient(Ingredient.of(Items.BOW)).build(consumer, BloodMagic.rl(basePath + "bow_power_anointment"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.SMELTING_ANOINTMENT.get()), 500, 100, 1).addIngredient(Ingredient.of(BloodMagicItems.SLATE_VIAL.get())).addIngredient(Ingredient.of(Tags.Items.CROPS_NETHER_WART)).addIngredient(Ingredient.of(Items.FURNACE)).addIngredient(Ingredient.of(Items.CHARCOAL, Items.COAL)).build(consumer, BloodMagic.rl(basePath + "smelting_anointment"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.BOW_VELOCITY_ANOINTMENT.get()), 500, 100, 1).addIngredient(Ingredient.of(BloodMagicItems.SLATE_VIAL.get())).addIngredient(Ingredient.of(Tags.Items.CROPS_NETHER_WART)).addIngredient(Ingredient.of(Tags.Items.NUGGETS_GOLD)).addIngredient(Ingredient.of(Items.BOW)).build(consumer, BloodMagic.rl(basePath + "bow_velocity_anointment"));

		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.FORTUNE_ANOINTMENT_L.get()), 1000, 100, 3).addIngredient(Ingredient.of(BloodMagicItems.FORTUNE_ANOINTMENT.get())).addIngredient(Ingredient.of(BloodMagicItems.TAU_OIL.get())).addIngredient(Ingredient.of(Tags.Items.DUSTS_REDSTONE)).addIngredient(Ingredient.of(BloodMagicTags.DUST_COAL)).build(consumer, BloodMagic.rl(basePath + "fortune_anointment_l"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.SILK_TOUCH_ANOINTMENT_L.get()), 1000, 100, 3).addIngredient(Ingredient.of(BloodMagicItems.SILK_TOUCH_ANOINTMENT.get())).addIngredient(Ingredient.of(BloodMagicItems.TAU_OIL.get())).addIngredient(Ingredient.of(Items.COBWEB)).addIngredient(Ingredient.of(Tags.Items.NUGGETS_GOLD)).build(consumer, BloodMagic.rl(basePath + "silk_touch_anointment_l"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.MELEE_DAMAGE_ANOINTMENT_L.get()), 1000, 100, 3).addIngredient(Ingredient.of(BloodMagicItems.MELEE_DAMAGE_ANOINTMENT.get())).addIngredient(Ingredient.of(BloodMagicItems.TAU_OIL.get())).addIngredient(Ingredient.of(Items.BLAZE_POWDER)).addIngredient(Ingredient.of(Tags.Items.GEMS_QUARTZ)).build(consumer, BloodMagic.rl(basePath + "melee_damage_anointment_l"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.HOLY_WATER_ANOINTMENT_L.get()), 1000, 100, 3).addIngredient(Ingredient.of(BloodMagicItems.HOLY_WATER_ANOINTMENT.get())).addIngredient(Ingredient.of(BloodMagicItems.TAU_OIL.get())).addIngredient(Ingredient.of(Items.GLISTERING_MELON_SLICE)).addIngredient(Ingredient.of(Tags.Items.GEMS_QUARTZ)).build(consumer, BloodMagic.rl(basePath + "holy_water_anointment_l"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.HIDDEN_KNOWLEDGE_ANOINTMENT_L.get()), 1000, 100, 3).addIngredient(Ingredient.of(BloodMagicItems.HIDDEN_KNOWLEDGE_ANOINTMENT.get())).addIngredient(Ingredient.of(BloodMagicItems.TAU_OIL.get())).addIngredient(Ingredient.of(Items.GLASS_BOTTLE)).addIngredient(Ingredient.of(Items.ENCHANTED_BOOK)).build(consumer, BloodMagic.rl(basePath + "hidden_knowledge_anointment_l"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.QUICK_DRAW_ANOINTMENT_L.get()), 1000, 100, 3).addIngredient(Ingredient.of(BloodMagicItems.QUICK_DRAW_ANOINTMENT.get())).addIngredient(Ingredient.of(BloodMagicItems.TAU_OIL.get())).addIngredient(Ingredient.of(Tags.Items.STRING)).addIngredient(Ingredient.of(Items.SPECTRAL_ARROW)).build(consumer, BloodMagic.rl(basePath + "quick_draw_anointment_l"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.LOOTING_ANOINTMENT_L.get()), 1000, 100, 3).addIngredient(Ingredient.of(BloodMagicItems.LOOTING_ANOINTMENT.get())).addIngredient(Ingredient.of(BloodMagicItems.TAU_OIL.get())).addIngredient(Ingredient.of(Tags.Items.GEMS_LAPIS)).addIngredient(Ingredient.of(Tags.Items.BONES)).build(consumer, BloodMagic.rl(basePath + "looting_anointment_l"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.BOW_POWER_ANOINTMENT_L.get()), 1000, 100, 3).addIngredient(Ingredient.of(BloodMagicItems.BOW_POWER_ANOINTMENT.get())).addIngredient(Ingredient.of(BloodMagicItems.TAU_OIL.get())).addIngredient(Ingredient.of(Tags.Items.INGOTS_IRON)).addIngredient(Ingredient.of(Items.BOW)).build(consumer, BloodMagic.rl(basePath + "bow_power_anointment_l"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.SMELTING_ANOINTMENT_L.get()), 1000, 100, 3).addIngredient(Ingredient.of(BloodMagicItems.SMELTING_ANOINTMENT.get())).addIngredient(Ingredient.of(BloodMagicItems.TAU_OIL.get())).addIngredient(Ingredient.of(Items.FURNACE)).addIngredient(Ingredient.of(Items.CHARCOAL, Items.COAL)).build(consumer, BloodMagic.rl(basePath + "smelting_anointment_l"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.BOW_VELOCITY_ANOINTMENT_L.get()), 1000, 100, 3).addIngredient(Ingredient.of(BloodMagicItems.BOW_VELOCITY_ANOINTMENT.get())).addIngredient(Ingredient.of(BloodMagicItems.TAU_OIL.get())).addIngredient(Ingredient.of(Tags.Items.NUGGETS_GOLD)).addIngredient(Ingredient.of(Items.BOW)).build(consumer, BloodMagic.rl(basePath + "bow_velocity_anointment_l"));

		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.FORTUNE_ANOINTMENT_2.get()), 1000, 100, 3).addIngredient(Ingredient.of(BloodMagicItems.FORTUNE_ANOINTMENT.get())).addIngredient(Ingredient.of(BloodMagicItems.STRONG_TAU_ITEM.get())).addIngredient(Ingredient.of(Tags.Items.DUSTS_REDSTONE)).addIngredient(Ingredient.of(BloodMagicTags.DUST_COAL)).build(consumer, BloodMagic.rl(basePath + "fortune_anointment_2"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.MELEE_DAMAGE_ANOINTMENT_2.get()), 1000, 100, 3).addIngredient(Ingredient.of(BloodMagicItems.MELEE_DAMAGE_ANOINTMENT.get())).addIngredient(Ingredient.of(BloodMagicItems.STRONG_TAU_ITEM.get())).addIngredient(Ingredient.of(Items.BLAZE_POWDER)).addIngredient(Ingredient.of(Tags.Items.GEMS_QUARTZ)).build(consumer, BloodMagic.rl(basePath + "melee_damage_anointment_2"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.HOLY_WATER_ANOINTMENT_2.get()), 1000, 100, 3).addIngredient(Ingredient.of(BloodMagicItems.HOLY_WATER_ANOINTMENT.get())).addIngredient(Ingredient.of(BloodMagicItems.STRONG_TAU_ITEM.get())).addIngredient(Ingredient.of(Items.GLISTERING_MELON_SLICE)).addIngredient(Ingredient.of(Tags.Items.GEMS_QUARTZ)).build(consumer, BloodMagic.rl(basePath + "holy_water_anointment_2"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.HIDDEN_KNOWLEDGE_ANOINTMENT_2.get()), 1000, 100, 3).addIngredient(Ingredient.of(BloodMagicItems.HIDDEN_KNOWLEDGE_ANOINTMENT.get())).addIngredient(Ingredient.of(BloodMagicItems.STRONG_TAU_ITEM.get())).addIngredient(Ingredient.of(Items.GLASS_BOTTLE)).addIngredient(Ingredient.of(Items.ENCHANTED_BOOK)).build(consumer, BloodMagic.rl(basePath + "hidden_knowledge_anointment_2"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.QUICK_DRAW_ANOINTMENT_2.get()), 1000, 100, 3).addIngredient(Ingredient.of(BloodMagicItems.QUICK_DRAW_ANOINTMENT.get())).addIngredient(Ingredient.of(BloodMagicItems.STRONG_TAU_ITEM.get())).addIngredient(Ingredient.of(Tags.Items.STRING)).addIngredient(Ingredient.of(Items.SPECTRAL_ARROW)).build(consumer, BloodMagic.rl(basePath + "quick_draw_anointment_2"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.LOOTING_ANOINTMENT_2.get()), 1000, 100, 3).addIngredient(Ingredient.of(BloodMagicItems.LOOTING_ANOINTMENT.get())).addIngredient(Ingredient.of(BloodMagicItems.STRONG_TAU_ITEM.get())).addIngredient(Ingredient.of(Tags.Items.GEMS_LAPIS)).addIngredient(Ingredient.of(Tags.Items.BONES)).build(consumer, BloodMagic.rl(basePath + "looting_anointment_2"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.BOW_POWER_ANOINTMENT_2.get()), 1000, 100, 3).addIngredient(Ingredient.of(BloodMagicItems.BOW_POWER_ANOINTMENT.get())).addIngredient(Ingredient.of(BloodMagicItems.STRONG_TAU_ITEM.get())).addIngredient(Ingredient.of(Tags.Items.INGOTS_IRON)).addIngredient(Ingredient.of(Items.BOW)).build(consumer, BloodMagic.rl(basePath + "bow_power_anointment_2"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.BOW_VELOCITY_ANOINTMENT_2.get()), 1000, 100, 3).addIngredient(Ingredient.of(BloodMagicItems.BOW_VELOCITY_ANOINTMENT.get())).addIngredient(Ingredient.of(BloodMagicItems.STRONG_TAU_ITEM.get())).addIngredient(Ingredient.of(Tags.Items.NUGGETS_GOLD)).addIngredient(Ingredient.of(Items.BOW)).build(consumer, BloodMagic.rl(basePath + "bow_velocity_anointment_2"));

		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(Items.WATER_BUCKET), 300, 60, 1).addIngredient(Ingredient.of(BloodMagicItems.WATER_SIGIL.get())).addIngredient(Ingredient.of(Items.BUCKET)).build(consumer, BloodMagic.rl(basePath + "sigil_water_bucket"));
		AlchemyTableRecipeBuilder.alchemyTable(waterbottleStack, 100, 60, 1).addIngredient(Ingredient.of(BloodMagicItems.WATER_SIGIL.get())).addIngredient(Ingredient.of(Items.GLASS_BOTTLE)).build(consumer, BloodMagic.rl(basePath + "sigil_water_bottle"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(Items.LAVA_BUCKET), 1000, 100, 1).addIngredient(Ingredient.of(BloodMagicItems.LAVA_SIGIL.get())).addIngredient(Ingredient.of(Items.BUCKET)).build(consumer, BloodMagic.rl(basePath + "sigil_lava_bucket"));

		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(Items.LEATHER, 4), 400, 200, 1).addIngredient(Ingredient.of(Items.ROTTEN_FLESH)).addIngredient(Ingredient.of(Items.ROTTEN_FLESH)).addIngredient(Ingredient.of(Items.ROTTEN_FLESH)).addIngredient(Ingredient.of(Items.ROTTEN_FLESH)).addIngredient(Ingredient.of(Items.FLINT)).addIngredient(Ingredient.of(BloodMagicItems.WATER_SIGIL.get())).build(consumer, BloodMagic.rl(basePath + "leather_from_flesh_sigil"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(Items.CLAY_BALL, 2), 350, 100, 2).addIngredient(Ingredient.of(Tags.Items.SAND)).addIngredient(Ingredient.of(Tags.Items.SAND)).addIngredient(Ingredient.of(BloodMagicItems.WATER_SIGIL.get())).build(consumer, BloodMagic.rl(basePath + "clay_from_sand_sigil"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.BASIC_CUTTING_FLUID.get()), 1100, 200, 1).addIngredient(Ingredient.of(BloodMagicItems.PLANT_OIL.get())).addIngredient(Ingredient.of(Tags.Items.DUSTS_REDSTONE)).addIngredient(Ingredient.of(Tags.Items.GUNPOWDER)).addIngredient(Ingredient.of(Items.SUGAR)).addIngredient(Ingredient.of(BloodMagicTags.DUST_COAL)).addIngredient(Ingredient.of(BloodMagicItems.WATER_SIGIL.get())).build(consumer, BloodMagic.rl(basePath + "basic_cutting_fluid_sigil"));

		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.FRAME_PARTS.get(), 2), 1000, 100, 3).addIngredient(Ingredient.of(Tags.Items.GLASS)).addIngredient(Ingredient.of(Tags.Items.STONE)).addIngredient(Ingredient.of(BloodMagicItems.SLATE.get())).build(consumer, BloodMagic.rl(basePath + "component_frame_parts"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.ITEM_ROUTER_FILTER.get()), 500, 100, 3).addIngredient(Ingredient.of(BloodMagicItems.FRAME_PARTS.get())).addIngredient(Ingredient.of(Tags.Items.LEATHER)).addIngredient(Ingredient.of(Tags.Items.DUSTS_REDSTONE)).addIngredient(Ingredient.of(Tags.Items.DYES_RED)).build(consumer, BloodMagic.rl(basePath + "router_filter"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.ITEM_TAG_FILTER.get()), 500, 100, 3).addIngredient(Ingredient.of(BloodMagicItems.FRAME_PARTS.get())).addIngredient(Ingredient.of(Tags.Items.INGOTS)).addIngredient(Ingredient.of(Tags.Items.DUSTS_REDSTONE)).addIngredient(Ingredient.of(Items.CLAY_BALL)).build(consumer, BloodMagic.rl(basePath + "tag_router_filter"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.ITEM_MOD_FILTER.get()), 500, 100, 3).addIngredient(Ingredient.of(BloodMagicItems.FRAME_PARTS.get())).addIngredient(Ingredient.of(BloodMagicItems.REINFORCED_SLATE.get())).addIngredient(Ingredient.of(Tags.Items.DUSTS_REDSTONE)).addIngredient(Ingredient.of(Tags.Items.DYES_YELLOW)).build(consumer, BloodMagic.rl(basePath + "mod_router_filter"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.ITEM_ENCHANT_FILTER.get()), 500, 100, 3).addIngredient(Ingredient.of(BloodMagicItems.FRAME_PARTS.get())).addIngredient(Ingredient.of(Items.ENCHANTED_BOOK)).addIngredient(Ingredient.of(Tags.Items.DUSTS_REDSTONE)).addIngredient(Ingredient.of(Items.PAPER)).build(consumer, BloodMagic.rl(basePath + "enchant_router_filter"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.ITEM_COMPOSITE_FILTER.get()), 1000, 200, 3).addIngredient(Ingredient.of(BloodMagicItems.FRAME_PARTS.get())).addIngredient(Ingredient.of(Tags.Items.DUSTS_GLOWSTONE)).addIngredient(Ingredient.of(Tags.Items.DUSTS_REDSTONE)).addIngredient(Ingredient.of(BloodMagicItems.IMBUED_SLATE.get())).build(consumer, BloodMagic.rl(basePath + "composite_router_filter"));

		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.TAU_OIL.get()), 500, 200, 3).addIngredient(Ingredient.of(BloodMagicItems.WEAK_TAU_ITEM.get())).addIngredient(Ingredient.of(BloodMagicItems.WEAK_TAU_ITEM.get())).addIngredient(Ingredient.of(BloodMagicItems.WEAK_TAU_ITEM.get())).addIngredient(Ingredient.of(Items.BONE_MEAL)).build(consumer, BloodMagic.rl(basePath + "tau_oil"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.INTERMEDIATE_CUTTING_FLUID.get()), 2000, 200, 3).addIngredient(Ingredient.of(BloodMagicItems.TAU_OIL.get())).addIngredient(Ingredient.of(Tags.Items.DUSTS_GLOWSTONE)).addIngredient(Ingredient.of(Tags.Items.GUNPOWDER)).addIngredient(Ingredient.of(Items.SUGAR)).addIngredient(Ingredient.of(BloodMagicTags.DUST_SULFUR)).addIngredient(Ingredient.of(waterbottleStack)).build(consumer, BloodMagic.rl(basePath + "intermediate_cutting_fluid"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.INTERMEDIATE_CUTTING_FLUID.get()), 2100, 200, 3).addIngredient(Ingredient.of(BloodMagicItems.TAU_OIL.get())).addIngredient(Ingredient.of(Tags.Items.DUSTS_GLOWSTONE)).addIngredient(Ingredient.of(Tags.Items.GUNPOWDER)).addIngredient(Ingredient.of(Items.SUGAR)).addIngredient(Ingredient.of(BloodMagicTags.DUST_SULFUR)).addIngredient(Ingredient.of(BloodMagicItems.WATER_SIGIL.get())).build(consumer, BloodMagic.rl(basePath + "intermediate_cutting_fluid_sigil"));

		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.SALTPETER.get(), 3), 200, 200, 1).addIngredient(Ingredient.of(BloodMagicItems.PLANT_OIL.get())).addIngredient(Ingredient.of(BloodMagicItems.PLANT_OIL.get())).addIngredient(Ingredient.of(BloodMagicTags.DUST_COAL)).build(consumer, BloodMagic.rl(basePath + "saltpeter"));

		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.SIMPLE_CATALYST.get(), 2), 200, 100, 2).addIngredient(Ingredient.of(Items.SUGAR)).addIngredient(Ingredient.of(Tags.Items.DUSTS_REDSTONE)).addIngredient(Ingredient.of(Tags.Items.DUSTS_GLOWSTONE)).addIngredient(Ingredient.of(Tags.Items.GUNPOWDER)).addIngredient(Ingredient.of(Tags.Items.CROPS_NETHER_WART)).build(consumer, BloodMagic.rl(basePath + "simple_catalyst"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.MUNDANE_POWER_CATALYST.get()), 1000, 100, 4).addIngredient(Ingredient.of(BloodMagicItems.STRONG_TAU_ITEM.get())).addIngredient(Ingredient.of(BloodMagicItems.SIMPLE_CATALYST.get())).addIngredient(Ingredient.of(Tags.Items.DUSTS_GLOWSTONE)).addIngredient(Ingredient.of(Tags.Items.DUSTS_GLOWSTONE)).build(consumer, BloodMagic.rl(basePath + "mundane_power"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.MUNDANE_LENGTHENING_CATALYST.get()), 1000, 100, 4).addIngredient(Ingredient.of(BloodMagicItems.WEAK_TAU_ITEM.get())).addIngredient(Ingredient.of(BloodMagicItems.SIMPLE_CATALYST.get())).addIngredient(Ingredient.of(Tags.Items.DUSTS_REDSTONE)).addIngredient(Ingredient.of(Tags.Items.DUSTS_REDSTONE)).build(consumer, BloodMagic.rl(basePath + "mundane_lengthening"));

		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.COMBINATIONAL_CATALYST.get()), 2000, 100, 4).addIngredient(Ingredient.of(BloodMagicItems.SIMPLE_CATALYST.get())).addIngredient(Ingredient.of(Items.BROWN_MUSHROOM)).addIngredient(Ingredient.of(Items.RED_MUSHROOM)).addIngredient(Ingredient.of(Items.SLIME_BALL)).addIngredient(Ingredient.of(BloodMagicTags.DUST_COAL)).build(consumer, BloodMagic.rl(basePath + "combinational"));

		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.WEAK_FILLING_AGENT.get()), 2000, 100, 2).addIngredient(Ingredient.of(BloodMagicItems.SIMPLE_CATALYST.get())).addIngredient(Ingredient.of(Items.SUGAR_CANE)).addIngredient(Ingredient.of(Items.CRIMSON_FUNGUS)).addIngredient(Ingredient.of(Items.WARPED_FUNGUS)).build(consumer, BloodMagic.rl(basePath + "weak_filling"));
		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.CYCLING_CATALYST.get()), 1000, 100, 2).addIngredient(Ingredient.of(BloodMagicItems.SIMPLE_CATALYST.get())).addIngredient(Ingredient.of(Tags.Items.GEMS_LAPIS)).addIngredient(Ingredient.of(Tags.Items.GEMS_LAPIS)).addIngredient(Ingredient.of(Tags.Items.DYES_GREEN)).addIngredient(Ingredient.of(Tags.Items.SAND)).build(consumer, BloodMagic.rl(basePath + "cycling_catalyst"));

		AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.HELLFORGED_SAND.get(), 2), 1000, 100, 5).addIngredient(Ingredient.of(BloodMagicItems.HELLFORGED_SAND.get())).addIngredient(Ingredient.of(BloodMagicItems.CORRUPTED_DUST.get())).addIngredient(Ingredient.of(BloodMagicTags.DUST_COPPER)).addIngredient(Ingredient.of(BloodMagicTags.DUST_GOLD)).build(consumer, BloodMagic.rl(basePath + "hellforged_sand"));

		// Changed Recipes
		{

		}
		{
			AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.ARCANE_ASHES.get()), 500, 200, 1).addIngredient(Ingredient.of(Tags.Items.DUSTS_REDSTONE)).addIngredient(Ingredient.of(Tags.Items.DYES_WHITE)).addIngredient(Ingredient.of(Tags.Items.GUNPOWDER)).addIngredient(Ingredient.of(ItemTags.COALS)).build(consumer, BloodMagic.rl(basePath + "arcane_ash"));
			AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.REAGENT_AIR.get()), 2000, 200, 2).addIngredient(Ingredient.of(Items.GHAST_TEAR)).addIngredient(Ingredient.of(Tags.Items.FEATHERS)).addIngredient(Ingredient.of(Tags.Items.FEATHERS)).build(consumer, BloodMagic.rl(basePath + "reagent_air"));
			AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.REAGENT_WATER.get()), 300, 200, 1).addIngredient(Ingredient.of(Items.SUGAR)).addIngredient(Ingredient.of(Items.WATER_BUCKET)).addIngredient(Ingredient.of(Items.WATER_BUCKET)).build(consumer, BloodMagic.rl(basePath + "reagent_water"));
			AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.REAGENT_LAVA.get()), 1000, 200, 1).addIngredient(Ingredient.of(Items.LAVA_BUCKET)).addIngredient(Ingredient.of(Tags.Items.DUSTS_REDSTONE)).addIngredient(Ingredient.of(Tags.Items.COBBLESTONE)).addIngredient(Ingredient.of(Tags.Items.STORAGE_BLOCKS_COAL)).build(consumer, BloodMagic.rl(basePath + "reagent_lava"));
			AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.REAGENT_VOID.get()), 1000, 200, 2).addIngredient(Ingredient.of(Items.BUCKET)).addIngredient(Ingredient.of(Tags.Items.STRING)).addIngredient(Ingredient.of(Tags.Items.STRING)).addIngredient(Ingredient.of(Tags.Items.GUNPOWDER)).build(consumer, BloodMagic.rl(basePath + "reagent_void"));
			AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.REAGENT_GROWTH.get()), 2000, 200, 2).addIngredient(Ingredient.of(ItemTags.SAPLINGS)).addIngredient(Ingredient.of(ItemTags.SAPLINGS)).addIngredient(Ingredient.of(Items.SUGAR_CANE)).addIngredient(Ingredient.of(Items.SUGAR)).build(consumer, BloodMagic.rl(basePath + "reagent_growth"));
			AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.REAGENT_MAGNETISM.get()), 1000, 200, 3).addIngredient(Ingredient.of(Tags.Items.STRING)).addIngredient(Ingredient.of(Tags.Items.INGOTS_GOLD)).addIngredient(Ingredient.of(Tags.Items.INGOTS_GOLD)).addIngredient(Ingredient.of(Tags.Items.STORAGE_BLOCKS_IRON)).build(consumer, BloodMagic.rl(basePath + "reagent_magnetism"));
			AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.REAGENT_FAST_MINER.get()), 2000, 200, 2).addIngredient(Ingredient.of(Items.IRON_PICKAXE)).addIngredient(Ingredient.of(Items.IRON_AXE)).addIngredient(Ingredient.of(Items.IRON_SHOVEL)).addIngredient(Ingredient.of(Tags.Items.GUNPOWDER)).build(consumer, BloodMagic.rl(basePath + "reagent_fastminer"));
			AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.REAGENT_BLOOD_LIGHT.get()), 1000, 200, 3).addIngredient(Ingredient.of(Tags.Items.DUSTS_GLOWSTONE)).addIngredient(Ingredient.of(Items.TORCH)).addIngredient(Ingredient.of(Tags.Items.DUSTS_REDSTONE)).addIngredient(Ingredient.of(Tags.Items.DUSTS_REDSTONE)).build(consumer, BloodMagic.rl(basePath + "reagent_blood_light"));
			AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.REAGENT_SIGHT.get()), 500, 200, 1).addIngredient(Ingredient.of(Tags.Items.DUSTS_GLOWSTONE)).addIngredient(Ingredient.of(Tags.Items.GLASS)).addIngredient(Ingredient.of(Tags.Items.GLASS)).addIngredient(Ingredient.of(BloodMagicItems.DIVINATION_SIGIL.get())).build(consumer, BloodMagic.rl(basePath + "reagent_sight"));
			AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.REAGENT_BINDING.get()), 1000, 200, 3).addIngredient(Ingredient.of(Tags.Items.DUSTS_GLOWSTONE)).addIngredient(Ingredient.of(Tags.Items.DUSTS_REDSTONE)).addIngredient(Ingredient.of(Tags.Items.GUNPOWDER)).addIngredient(Ingredient.of(Tags.Items.NUGGETS_GOLD)).build(consumer, BloodMagic.rl(basePath + "reagent_binding"));
			AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.REAGENT_HOLDING.get()), 2000, 200, 2).addIngredient(Ingredient.of(Tags.Items.CHESTS)).addIngredient(Ingredient.of(Tags.Items.LEATHER)).addIngredient(Ingredient.of(Tags.Items.STRING)).addIngredient(Ingredient.of(Tags.Items.STRING)).build(consumer, BloodMagic.rl(basePath + "reagent_holding"));
			AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.REAGENT_SUPPRESSION.get()), 10000, 200, 4).addIngredient(Ingredient.of(BloodMagicBlocks.TELEPOSER.get())).addIngredient(Ingredient.of(BloodMagicItems.VOID_SIGIL.get())).addIngredient(Ingredient.of(Tags.Items.INGOTS_GOLD)).addIngredient(Ingredient.of(Items.BUCKET)).build(consumer, BloodMagic.rl(basePath + "reagent_suppression"));
			AlchemyTableRecipeBuilder.alchemyTable(new ItemStack(BloodMagicItems.REAGENT_TELEPOSITION.get()), 10000, 200, 4).addIngredient(Ingredient.of(BloodMagicBlocks.TELEPOSER.get())).addIngredient(Ingredient.of(Tags.Items.INGOTS_GOLD)).addIngredient(Ingredient.of(Items.ENDER_PEARL)).addIngredient(Ingredient.of(Items.CHORUS_FRUIT)).build(consumer, BloodMagic.rl(basePath + "reagent_teleposition"));
		}

		ItemStack brillianceTome = new ItemStack(BloodMagicItems.LIVING_TOME.get());
		((ItemLivingTome) BloodMagicItems.LIVING_TOME.get()).updateLivingStats(brillianceTome, new LivingStatsDummy().setMaxPoints(LivingArmorRegistrar.UPGRADE_DIAMOND.get().getLevelCost(1)).addExperience(LivingArmorRegistrar.UPGRADE_DIAMOND.get().getKey(), 5));

		AlchemyTableRecipeBuilder.alchemyTable(brillianceTome, 2000, 150, 3).addIngredient(Ingredient.of(Tags.Items.GEMS_DIAMOND)).addIngredient(Ingredient.of(Tags.Items.GEMS_DIAMOND)).addIngredient(Ingredient.of(Tags.Items.GEMS_DIAMOND)).addIngredient(Ingredient.of(Tags.Items.GEMS_DIAMOND)).addIngredient(Ingredient.of(Tags.Items.GEMS_DIAMOND)).addIngredient(Ingredient.of(BloodMagicItems.REAGENT_BINDING.get())).build(consumer, BloodMagic.rl(basePath + "upgrade_brilliance"));

		String filterPath = "alchemytable/filter/";

		ItemStack enchantStack = new ItemStack(BloodMagicItems.ITEM_ENCHANT_FILTER.get());
		ItemStack tagStack = new ItemStack(BloodMagicItems.ITEM_TAG_FILTER.get());
		ItemStack modStack = new ItemStack(BloodMagicItems.ITEM_MOD_FILTER.get());
		// Filter combination recipes
		ItemStack itemPlusEnchantStack = new ItemStack(BloodMagicItems.ITEM_ROUTER_FILTER.get());
		((ItemStandardFilter) BloodMagicItems.ITEM_ROUTER_FILTER.get()).nestFilter(itemPlusEnchantStack, enchantStack);

		ItemStack compositePlusEnchant = new ItemStack(BloodMagicItems.ITEM_COMPOSITE_FILTER.get());
		ItemStack compositePlusTag = new ItemStack(BloodMagicItems.ITEM_COMPOSITE_FILTER.get());
		ItemStack compositePlusMod = new ItemStack(BloodMagicItems.ITEM_COMPOSITE_FILTER.get());
		((ItemCompositeFilter) BloodMagicItems.ITEM_COMPOSITE_FILTER.get()).nestFilter(compositePlusEnchant, enchantStack);
		((ItemCompositeFilter) BloodMagicItems.ITEM_COMPOSITE_FILTER.get()).nestFilter(compositePlusTag, tagStack);
		((ItemCompositeFilter) BloodMagicItems.ITEM_COMPOSITE_FILTER.get()).nestFilter(compositePlusMod, modStack);

		FilterMergeAlchemyTableRecipeBuilder.alchemyTable(Ingredient.of(BloodMagicItems.ITEM_COMPOSITE_FILTER.get()), 500, 100, 0).addOptionalOutputStack(compositePlusEnchant).addIngredient(Ingredient.of(BloodMagicItems.ITEM_ENCHANT_FILTER.get())).addIngredient(Ingredient.of(Tags.Items.SLIMEBALLS)).build(consumer, BloodMagic.rl(filterPath + "composite_enchant_filter"));
		FilterMergeAlchemyTableRecipeBuilder.alchemyTable(Ingredient.of(BloodMagicItems.ITEM_COMPOSITE_FILTER.get()), 500, 100, 0).addOptionalOutputStack(compositePlusTag).addIngredient(Ingredient.of(BloodMagicItems.ITEM_TAG_FILTER.get())).addIngredient(Ingredient.of(Tags.Items.SLIMEBALLS)).build(consumer, BloodMagic.rl(filterPath + "composite_tag_filter"));
		FilterMergeAlchemyTableRecipeBuilder.alchemyTable(Ingredient.of(BloodMagicItems.ITEM_COMPOSITE_FILTER.get()), 500, 100, 0).addOptionalOutputStack(compositePlusMod).addIngredient(Ingredient.of(BloodMagicItems.ITEM_MOD_FILTER.get())).addIngredient(Ingredient.of(Tags.Items.SLIMEBALLS)).build(consumer, BloodMagic.rl(filterPath + "composite_mod_filter"));
	}
}
