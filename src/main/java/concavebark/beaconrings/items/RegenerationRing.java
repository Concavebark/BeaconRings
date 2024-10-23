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

public class RegenerationRing extends Item {
    public RegenerationRing(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!user.hasStatusEffect(StatusEffects.REGENERATION)) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, -1, 0, false, false, true));
            user.playSound(SoundEvents.BLOCK_BEACON_POWER_SELECT);
        } else {
            user.removeStatusEffect(StatusEffects.REGENERATION);
            user.playSound(SoundEvents.BLOCK_BEACON_DEACTIVATE);
        }
        return super.use(world, user, hand);
    }
}
