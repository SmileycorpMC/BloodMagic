package WayofTime.bloodmagic.teleport;

import WayofTime.bloodmagic.util.Constants;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;

import java.io.Serializable;

public class PortalLocation implements Serializable {
    private int x;
    private int y;
    private int z;
    private int dimension;

    public PortalLocation(int x, int y, int z, int dimension) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.dimension = dimension;
    }

    public PortalLocation(BlockPos blockPos, int dimension) {
        this(blockPos.getX(), blockPos.getY(), blockPos.getZ(), dimension);
    }

    public CompoundNBT writeToNBT(CompoundNBT tag) {
        CompoundNBT locationTag = new CompoundNBT();

        locationTag.setInteger(Constants.NBT.X_COORD, x);
        locationTag.setInteger(Constants.NBT.Y_COORD, y);
        locationTag.setInteger(Constants.NBT.Z_COORD, z);
        locationTag.setInteger(Constants.NBT.DIMENSION_ID, dimension);
        tag.setTag(Constants.NBT.PORTAL_LOCATION, locationTag);

        return tag;
    }

    public BlockPos getBlockPos() {
        return new BlockPos(x, y, z);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        PortalLocation that = (PortalLocation) o;

        if (x != that.x)
            return false;
        if (y != that.y)
            return false;
        return z == that.z;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + z;
        return result;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public int getDimension() {
        return dimension;
    }

    public static PortalLocation readFromNBT(CompoundNBT tag) {
        if (tag.hasKey(Constants.NBT.PORTAL_LOCATION)) {
            CompoundNBT locationTag = tag.getCompoundTag(Constants.NBT.PORTAL_LOCATION);
            return new PortalLocation(locationTag.getInteger(Constants.NBT.X_COORD), locationTag.getInteger(Constants.NBT.Y_COORD), locationTag.getInteger(Constants.NBT.Z_COORD), locationTag.getInteger(Constants.NBT.DIMENSION_ID));
        }
        return null;
    }
}
