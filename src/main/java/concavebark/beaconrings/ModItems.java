package concavebark.beaconrings;

import concavebark.beaconrings.items.*;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item MAX_RING = register(
            new MaxRing(new Item.Settings().maxCount(1)), "max_ring"
    );

    public static final Item REGENERATION_RING = register(
            new RegenerationRing(new Item.Settings().maxCount(1)), "regeneration_ring"
    );

    public static final Item SPEED_RING = register(
            new SpeedRing(new Item.Settings().maxCount(1)), "speed_ring"
    );

    public static final Item HASTE_RING = register(
            new HasteRing(new Item.Settings().maxCount(1)), "haste_ring"
    );

    public static final Item RESISTANCE_RING = register(
            new ResistanceRing(new Item.Settings().maxCount(1)), "resistance_ring"
    );

    public static final Item JUMP_BOOST_RING = register(
            new JumpBoostRing(new Item.Settings().maxCount(1)), "jump_boost_ring"
    );

    public static final Item STRENGTH_RING = register(
            new StrengthRing(new Item.Settings().maxCount(1)), "strength_ring"
    );

    public static final ItemGroup BEACONRINGS_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(REGENERATION_RING))
            .displayName(Text.translatable("itemGroup.beaconrings.beaconrings_group"))
            .entries((context, entries) -> {
                entries.add(REGENERATION_RING);
                entries.add(SPEED_RING);
                entries.add(HASTE_RING);
                entries.add(RESISTANCE_RING);
                entries.add(JUMP_BOOST_RING);
                entries.add(STRENGTH_RING);
                entries.add(MAX_RING);
            }).build();

    public static Item register(Item item, String id) {
        Identifier itemID = Identifier.of(BeaconRings.MOD_ID, id);

        return Registry.register(Registries.ITEM, itemID, item);
    }

    public static void initialize() {

        Registry.register(Registries.ITEM_GROUP, Identifier.of(BeaconRings.MOD_ID, "beaconrings_group"), BEACONRINGS_GROUP);

    }
}
