package wayoftime.bloodmagic.impl;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import wayoftime.bloodmagic.altar.ComponentType;
import wayoftime.bloodmagic.api.IBloodMagicAPI;
import wayoftime.bloodmagic.common.block.BloodMagicBlocks;
import wayoftime.bloodmagic.incense.EnumTranquilityType;
import wayoftime.bloodmagic.incense.IncenseTranquilityRegistry;
import wayoftime.bloodmagic.incense.TranquilityStack;

public class BloodMagicCorePlugin
{
	public static final BloodMagicCorePlugin INSTANCE = new BloodMagicCorePlugin();

	public void register(IBloodMagicAPI apiInterface)
	{
		BloodMagicAPI api = (BloodMagicAPI) apiInterface;
		api.getValueManager().setTranquility(Blocks.LAVA, new TranquilityStack(EnumTranquilityType.LAVA, 1.2D));
//        api.getValueManager().setTranquility(Blocks.FLOWING_LAVA, new TranquilityStack(EnumTranquilityType.LAVA, 1.2D));
		api.getValueManager().setTranquility(Blocks.WATER, new TranquilityStack(EnumTranquilityType.WATER, 1.0D));
//        api.getValueManager().setTranquility(Blocks.water, new TranquilityStack(EnumTranquilityType.WATER, 1.0D));
		api.getValueManager().setTranquility(BloodMagicBlocks.LIFE_ESSENCE_BLOCK.get(), new TranquilityStack(EnumTranquilityType.WATER, 1.5D));
		api.getValueManager().setTranquility(Blocks.NETHERRACK, new TranquilityStack(EnumTranquilityType.FIRE, 0.5D));
		api.getValueManager().setTranquility(Blocks.DIRT, new TranquilityStack(EnumTranquilityType.EARTHEN, 0.25D));
		api.getValueManager().setTranquility(Blocks.FARMLAND, new TranquilityStack(EnumTranquilityType.EARTHEN, 1.0D));
		api.getValueManager().setTranquility(Blocks.POTATOES, new TranquilityStack(EnumTranquilityType.CROP, 1.0D));
		api.getValueManager().setTranquility(Blocks.CARROTS, new TranquilityStack(EnumTranquilityType.CROP, 1.0D));
		api.getValueManager().setTranquility(Blocks.WHEAT, new TranquilityStack(EnumTranquilityType.CROP, 1.0D));
		api.getValueManager().setTranquility(Blocks.NETHER_WART, new TranquilityStack(EnumTranquilityType.CROP, 1.0D));
		api.getValueManager().setTranquility(Blocks.BEETROOTS, new TranquilityStack(EnumTranquilityType.CROP, 1.0D));

		apiInterface.registerTranquilityHandler(state -> state.getBlock() instanceof LeavesBlock, EnumTranquilityType.PLANT.name(), 1.0D);
		apiInterface.registerTranquilityHandler(state -> state.getBlock() instanceof FireBlock, EnumTranquilityType.FIRE.name(), 1.0D);
		apiInterface.registerTranquilityHandler(state -> state.getBlock() instanceof GrassBlock, EnumTranquilityType.EARTHEN.name(), 0.5D);

		apiInterface.registerTranquilityHandler(state -> state.is(BlockTags.LOGS), EnumTranquilityType.TREE.name(), 1.0D);
		apiInterface.registerTranquilityHandler(state -> state.getBlock() instanceof SimpleWaterloggedBlock && state.getFluidState().isSource(), EnumTranquilityType.WATER.name(), 1.0D);

		IncenseTranquilityRegistry.registerTranquilityHandler((world, pos, block, state) -> BloodMagicAPI.INSTANCE.getValueManager().getTranquility().get(state));

		apiInterface.registerAltarComponent(Blocks.GLOWSTONE.defaultBlockState(), ComponentType.GLOWSTONE.name());
		apiInterface.registerAltarComponent(Blocks.SEA_LANTERN.defaultBlockState(), ComponentType.GLOWSTONE.name());
		apiInterface.registerAltarComponent(BloodMagicBlocks.BLOODSTONE.get().defaultBlockState(), ComponentType.BLOODSTONE.name());
		apiInterface.registerAltarComponent(BloodMagicBlocks.BLOODSTONE_BRICK.get().defaultBlockState(), ComponentType.BLOODSTONE.name());
		apiInterface.registerAltarComponent(Blocks.BEACON.defaultBlockState(), ComponentType.BEACON.name());

		apiInterface.registerAltarComponent(BloodMagicBlocks.BLANK_RUNE.get().defaultBlockState(), ComponentType.BLOODRUNE.name());
		apiInterface.registerAltarComponent(BloodMagicBlocks.SPEED_RUNE.get().defaultBlockState(), ComponentType.BLOODRUNE.name());
		apiInterface.registerAltarComponent(BloodMagicBlocks.SACRIFICE_RUNE.get().defaultBlockState(), ComponentType.BLOODRUNE.name());
		apiInterface.registerAltarComponent(BloodMagicBlocks.SELF_SACRIFICE_RUNE.get().defaultBlockState(), ComponentType.BLOODRUNE.name());
		apiInterface.registerAltarComponent(BloodMagicBlocks.DISPLACEMENT_RUNE.get().defaultBlockState(), ComponentType.BLOODRUNE.name());
		apiInterface.registerAltarComponent(BloodMagicBlocks.CAPACITY_RUNE.get().defaultBlockState(), ComponentType.BLOODRUNE.name());
		apiInterface.registerAltarComponent(BloodMagicBlocks.AUGMENTED_CAPACITY_RUNE.get().defaultBlockState(), ComponentType.BLOODRUNE.name());
		apiInterface.registerAltarComponent(BloodMagicBlocks.ORB_RUNE.get().defaultBlockState(), ComponentType.BLOODRUNE.name());
		apiInterface.registerAltarComponent(BloodMagicBlocks.ACCELERATION_RUNE.get().defaultBlockState(), ComponentType.BLOODRUNE.name());
		apiInterface.registerAltarComponent(BloodMagicBlocks.CHARGING_RUNE.get().defaultBlockState(), ComponentType.BLOODRUNE.name());

		apiInterface.registerAltarComponent(BloodMagicBlocks.SPEED_RUNE_2.get().defaultBlockState(), ComponentType.BLOODRUNE.name());
		apiInterface.registerAltarComponent(BloodMagicBlocks.SACRIFICE_RUNE_2.get().defaultBlockState(), ComponentType.BLOODRUNE.name());
		apiInterface.registerAltarComponent(BloodMagicBlocks.SELF_SACRIFICE_RUNE_2.get().defaultBlockState(), ComponentType.BLOODRUNE.name());
		apiInterface.registerAltarComponent(BloodMagicBlocks.DISPLACEMENT_RUNE_2.get().defaultBlockState(), ComponentType.BLOODRUNE.name());
		apiInterface.registerAltarComponent(BloodMagicBlocks.CAPACITY_RUNE_2.get().defaultBlockState(), ComponentType.BLOODRUNE.name());
		apiInterface.registerAltarComponent(BloodMagicBlocks.AUGMENTED_CAPACITY_RUNE_2.get().defaultBlockState(), ComponentType.BLOODRUNE.name());
		apiInterface.registerAltarComponent(BloodMagicBlocks.ORB_RUNE_2.get().defaultBlockState(), ComponentType.BLOODRUNE.name());
		apiInterface.registerAltarComponent(BloodMagicBlocks.ACCELERATION_RUNE_2.get().defaultBlockState(), ComponentType.BLOODRUNE.name());
		apiInterface.registerAltarComponent(BloodMagicBlocks.CHARGING_RUNE_2.get().defaultBlockState(), ComponentType.BLOODRUNE.name());

		apiInterface.registerInventoryProvider("mainInventory", player -> player.getInventory().items);
		apiInterface.registerInventoryProvider("armorInventory", player -> player.getInventory().armor);
		apiInterface.registerInventoryProvider("offHandInventory", player -> player.getInventory().offhand);
	}
}
