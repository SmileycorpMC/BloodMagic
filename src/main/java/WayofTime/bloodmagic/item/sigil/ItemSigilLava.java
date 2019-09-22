package WayofTime.bloodmagic.item.sigil;

import WayofTime.bloodmagic.core.data.SoulTicket;
import WayofTime.bloodmagic.iface.ISigil;
import WayofTime.bloodmagic.util.helper.NetworkHelper;
import WayofTime.bloodmagic.util.helper.PlayerHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;


public class ItemSigilLava extends ItemSigilFluidBase {

    public ItemSigilLava() {
        super("lava", 1000, new FluidStack(FluidRegistry.LAVA, 1000));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItem(hand);
        if (stack.getItem() instanceof ISigil.Holding)
            stack = ((Holding) stack.getItem()).getHeldItem(stack, player);
        if (PlayerHelper.isFakePlayer(player))
            return ActionResult.newResult(ActionResultType.FAIL, stack);

        if (!world.isRemote && !isUnusable(stack)) {
            RayTraceResult rayTrace = this.rayTrace(world, player, false);

            if (rayTrace == null || rayTrace.typeOfHit != RayTraceResult.Type.BLOCK) {
                return ActionResult.newResult(ActionResultType.PASS, stack);
            }

            BlockPos blockPos = rayTrace.getBlockPos();

            if (world.isBlockModifiable(player, blockPos) && player.canPlayerEdit(blockPos, rayTrace.sideHit, stack)) {
                //Case for if block at blockPos is a fluid handler like a tank
                //Try to put fluid into tank
                IFluidHandler destination = getFluidHandler(world, blockPos, null);
                if (destination != null && tryInsertSigilFluid(destination, false) && NetworkHelper.getSoulNetwork(getBinding(stack)).syphonAndDamage(player, SoulTicket.item(stack, world, player, getLpUsed())).isSuccess()) {
                    boolean result = tryInsertSigilFluid(destination, true);
                    if (result)
                        return ActionResult.newResult(ActionResultType.SUCCESS, stack);
                }
                //Do the same as above, but use sidedness to interact with the fluid handler.
                IFluidHandler destinationSide = getFluidHandler(world, blockPos, rayTrace.sideHit);
                if (destinationSide != null && tryInsertSigilFluid(destinationSide, false) && NetworkHelper.getSoulNetwork(getBinding(stack)).syphonAndDamage(player, SoulTicket.item(stack, world, player, getLpUsed())).isSuccess()) {
                    boolean result = tryInsertSigilFluid(destinationSide, true);
                    if (result)
                        return ActionResult.newResult(ActionResultType.SUCCESS, stack);
                }
                //Case for if block at blockPos is not a tank
                //Place fluid in world
                if (destination == null && destinationSide == null) {
                    BlockPos targetPos = blockPos.offset(rayTrace.sideHit);
                    if (tryPlaceSigilFluid(player, world, targetPos) && NetworkHelper.getSoulNetwork(getBinding(stack)).syphonAndDamage(player, SoulTicket.item(stack, world, player, getLpUsed())).isSuccess()) {
                        return ActionResult.newResult(ActionResultType.SUCCESS, stack);
                    }
                }
            }
        }
        return super.onItemRightClick(world, player, hand);
    }
}
