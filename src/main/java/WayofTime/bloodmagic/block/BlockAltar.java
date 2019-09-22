package WayofTime.bloodmagic.block;

import WayofTime.bloodmagic.BloodMagic;
import WayofTime.bloodmagic.altar.AltarUtil;
import WayofTime.bloodmagic.altar.ComponentType;
import WayofTime.bloodmagic.altar.IAltarManipulator;
import WayofTime.bloodmagic.altar.IBloodAltar;
import WayofTime.bloodmagic.client.IVariantProvider;
import WayofTime.bloodmagic.core.data.Binding;
import WayofTime.bloodmagic.core.data.SoulNetwork;
import WayofTime.bloodmagic.iface.IAltarReader;
import WayofTime.bloodmagic.iface.IBindable;
import WayofTime.bloodmagic.iface.IDocumentedBlock;
import WayofTime.bloodmagic.orb.BloodOrb;
import WayofTime.bloodmagic.orb.IBloodOrb;
import WayofTime.bloodmagic.tile.TileAltar;
import WayofTime.bloodmagic.util.Utils;
import WayofTime.bloodmagic.util.helper.NetworkHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class BlockAltar extends Block implements IVariantProvider, IDocumentedBlock, IBMBlock {
    public static final PropertyBool POWERED = PropertyBool.create("powered");
    private static final AxisAlignedBB BODY = new AxisAlignedBB(0, 0, 0, 16 / 16F, 12 / 16F, 16 / 16F);

    public BlockAltar() {
        super(Material.ROCK);
        this.setDefaultState(this.blockState.getBaseState().withProperty(POWERED, false));


        setTranslationKey(BloodMagic.MODID + ".altar");
        setCreativeTab(BloodMagic.TAB_BM);
        setHardness(2.0F);
        setResistance(5.0F);
        setHarvestLevel("pickaxe", 1);
    }

    public AxisAlignedBB getBoundingBox(BlockState state, IBlockAccess source, BlockPos pos) {
        return BODY;
    }

    @Override
    public boolean hasComparatorInputOverride(BlockState state) {
        return true;
    }

    @Override
    public int getComparatorInputOverride(BlockState state, World world, BlockPos pos) {
        if (world.isRemote)
            return 0;

        TileEntity tile = world.getTileEntity(pos);

        if (tile instanceof TileAltar) {
            TileAltar altar = (TileAltar) tile;
            ItemStack orbStack = altar.getStackInSlot(0);

            if (world.getBlockState(pos.down()).getBlock() instanceof BlockDecorative) {
                if (orbStack.getItem() instanceof IBloodOrb && orbStack.getItem() instanceof IBindable) {
                    BloodOrb orb = ((IBloodOrb) orbStack.getItem()).getOrb(orbStack);
                    Binding binding = ((IBindable) orbStack.getItem()).getBinding(orbStack);
                    if (orb != null && binding != null) {
                        SoulNetwork soulNetwork = NetworkHelper.getSoulNetwork(binding);

                        int maxEssence = orb.getCapacity();
                        int currentEssence = soulNetwork.getCurrentEssence();
                        int level = currentEssence * 15 / maxEssence;
                        return Math.min(15, level) % 16;
                    }
                }
            } else {
                int maxEssence = altar.getCapacity();
                int currentEssence = altar.getCurrentBlood();
                int level = currentEssence * 15 / maxEssence;
                return Math.min(15, level) % 16;
            }
        }

        return 0;
    }

    @Override
    public boolean isNormalCube(BlockState state, IBlockAccess world, BlockPos pos) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(BlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(BlockState state) {
        return false;
    }

    @Override
    public boolean causesSuffocation(BlockState state) {
        return true;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, BlockState state, PlayerEntity player, Hand hand, Direction side, float hitX, float hitY, float hitZ) {
        TileAltar altar = (TileAltar) world.getTileEntity(pos);

        if (altar == null || player.isSneaking())
            return false;

        ItemStack playerItem = player.getHeldItem(hand);

        if (playerItem.getItem() instanceof IAltarReader || playerItem.getItem() instanceof IAltarManipulator) {
            playerItem.getItem().onItemRightClick(world, player, hand);
            return true;
        }

        if (Utils.insertItemToTile(altar, player))
            altar.startCycle();
        else
            altar.setActive();

        world.notifyBlockUpdate(pos, state, state, 3);
        return true;
    }

    @Override
    public void breakBlock(World world, BlockPos blockPos, BlockState blockState) {
        TileEntity tile = world.getTileEntity(blockPos);
        if (tile instanceof TileAltar)
            ((TileAltar) tile).dropItems();

        super.breakBlock(world, blockPos, blockState);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, BlockState state) {
        return new TileAltar();
    }

    // IDocumentedBlock

    @Override
    public List<ITextComponent> getDocumentation(PlayerEntity player, World world, BlockPos pos, BlockState state) {
        List<ITextComponent> docs = new ArrayList<>();
        IBloodAltar altar = ((IBloodAltar) world.getTileEntity(pos));
        Pair<BlockPos, ComponentType> missingBlock = AltarUtil.getFirstMissingComponent(world, pos, altar.getTier().toInt());
        if (missingBlock != null)
            docs.add(new TranslationTextComponent("chat.bloodmagic.altar.nextTier", new TranslationTextComponent(missingBlock.getRight().getKey()), Utils.prettifyBlockPosString(missingBlock.getLeft())));

        return docs;
    }

    @Override
    public BlockItem getItem() {
        return new BlockItem(this);
    }

    /* Redstone code, taken from BlockLever */

    public int getWeakPower(BlockState blockState, IBlockAccess blockAccess, BlockPos pos, Direction side) {
        return blockState.getValue(POWERED) ? 15 : 0;
    }

    public int getStrongPower(BlockState blockState, IBlockAccess blockAccess, BlockPos pos, Direction side) {
        if (!blockState.getValue(POWERED)) {
            return 0;
        } else {
            return 15;
        }
    }

    public boolean canProvidePower(BlockState state) {
        return true;
    }

    public BlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(POWERED, meta > 0);
    }

    public int getMetaFromState(BlockState state) {
        return state.getValue(POWERED) ? 1 : 0;
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, POWERED);
    }

    public BlockState getStateForPlacement(World worldIn, BlockPos pos, Direction facing, float hitX, float hitY, float hitZ, int meta, LivingEntity placer) {

        return this.getDefaultState().withProperty(POWERED, false);
    }
}
