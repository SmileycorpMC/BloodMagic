package WayofTime.bloodmagic.fakePlayer;

import com.mojang.authlib.GameProfile;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.ServerWorld;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fml.common.FMLCommonHandler;

import javax.annotation.Nullable;

/**
 * All credits for this go to CrazyPants, from EIO
 */
@SuppressWarnings("EntityConstructor")
public class FakePlayerBM extends FakePlayer {

    public FakePlayerBM(ServerWorld world, GameProfile name) {
        super(world, name);
    }

    public FakePlayerBM(World world, BlockPos pos, GameProfile profile) {
        super(FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(world.provider.getDimension()), profile);
        posX = pos.getX() + 0.5;
        posY = pos.getY() + 0.5;
        posZ = pos.getZ() + 0.5;
        connection = new FakeNetHandlerPlayServer(this);
    }

    @Override
    protected void onNewPotionEffect(EffectInstance p_70670_1_) {
    }

    @Override
    protected void onChangedPotionEffect(EffectInstance effect, boolean p_70695_2_) {
    }

    @Override
    protected void onFinishedPotionEffect(EffectInstance effect) {
    }

    protected void playEquipSound(@Nullable ItemStack stack) {
    }
}