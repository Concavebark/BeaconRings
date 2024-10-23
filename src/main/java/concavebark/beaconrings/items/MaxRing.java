package concavebark.beaconrings.items;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class MaxRing extends Item {

    boolean hasHaste = false;
    boolean hasJumpBoost = false;
    boolean hasRegeneration = false;
    boolean hasResistance = false;
    boolean hasSpeed = false;
    boolean hasStrength = false;

    public MaxRing(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        //haste, jump_boost, regeneration, resistance, speed, strength
        hasHaste = user.hasStatusEffect(StatusEffects.HASTE);
        hasJumpBoost = user.hasStatusEffect(StatusEffects.JUMP_BOOST);
        hasRegeneration = user.hasStatusEffect(StatusEffects.REGENERATION);
        hasResistance = user.hasStatusEffect(StatusEffects.RESISTANCE);
        hasSpeed = user.hasStatusEffect(StatusEffects.SPEED);
        hasStrength = user.hasStatusEffect(StatusEffects.STRENGTH);

        if (hasHaste && hasJumpBoost && hasRegeneration && hasResistance && hasSpeed && hasStrength) {
            // remove them all
            user.removeStatusEffect(StatusEffects.HASTE);
            user.removeStatusEffect(StatusEffects.JUMP_BOOST);
            user.removeStatusEffect(StatusEffects.REGENERATION);
            user.removeStatusEffect(StatusEffects.RESISTANCE);
            user.removeStatusEffect(StatusEffects.SPEED);
            user.removeStatusEffect(StatusEffects.STRENGTH);
            user.playSound(SoundEvents.BLOCK_BEACON_DEACTIVATE);
        } else {
            // add all that aren't added
            if (!hasHaste) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, -1, 1, false, false, true));
            }
            if (!hasJumpBoost) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, -1, 1, false, false, true));
            }
            if (!hasRegeneration) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, -1, 0, false, false, true));
            }
            if (!hasResistance) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, -1, 1, false, false, true));
            }
            if (!hasSpeed) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, -1, 1, false, false, true));
            }
            if (!hasStrength) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, -1, 1, false, false, true));
            }
            user.playSound(SoundEvents.BLOCK_BEACON_POWER_SELECT);
        }
        return super.use(world, user, hand);
    }
}
