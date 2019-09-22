package WayofTime.bloodmagic.ritual.imperfect;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * This interface is for internal implementation only.
 * <p>
 * It is provided via the API for easy obtaining of basic data.
 */
public interface IImperfectRitualStone {

    boolean performRitual(World world, BlockPos pos, ImperfectRitual imperfectRitual, PlayerEntity player);

    World getRitualWorld();

    BlockPos getRitualPos();
}
