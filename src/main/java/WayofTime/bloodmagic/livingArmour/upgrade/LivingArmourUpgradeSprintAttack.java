package WayofTime.bloodmagic.livingArmour.upgrade;

import WayofTime.bloodmagic.BloodMagic;
import WayofTime.bloodmagic.livingArmour.LivingArmourUpgrade;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;

public class LivingArmourUpgradeSprintAttack extends LivingArmourUpgrade {
    public static final int[] costs = new int[]{3, 7, 15, 25, 40};
    public static final double[] damageBoost = new double[]{0.5, 0.75, 1, 1.25, 1.5};
    public static final double[] knockbackModifier = new double[]{1, 2, 3, 4, 5};

    public LivingArmourUpgradeSprintAttack(int level) {
        super(level);
    }

    @Override
    public double getAdditionalDamageOnHit(double damage, PlayerEntity wearer, LivingEntity hitEntity, ItemStack weapon) {
        if (wearer.isSprinting()) {
            return getDamageModifier();
        }

        return 0;
    }

    @Override
    public double getKnockbackOnHit(PlayerEntity wearer, LivingEntity hitEntity, ItemStack weapon) {
        if (wearer.isSprinting()) {
            return getKnockbackModifier();
        }

        return 0;
    }

    public double getDamageModifier() {
        return damageBoost[this.level];
    }

    public double getKnockbackModifier() {
        return knockbackModifier[this.level];
    }

    @Override
    public String getUniqueIdentifier() {
        return BloodMagic.MODID + ".upgrade.sprintAttack";
    }

    @Override
    public int getMaxTier() {
        return 5;
    }

    @Override
    public int getCostOfUpgrade() {
        return costs[this.level];
    }

    @Override
    public void writeToNBT(CompoundNBT tag) {
        // EMPTY
    }

    @Override
    public void readFromNBT(CompoundNBT tag) {
        // EMPTY
    }

    @Override
    public String getTranslationKey() {
        return tooltipBase + "sprintAttack";
    }
}