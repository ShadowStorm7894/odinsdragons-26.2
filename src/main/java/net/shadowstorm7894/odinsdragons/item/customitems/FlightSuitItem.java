package net.shadowstorm7894.odinsdragons.item.customitems;

import net.minecraft.core.component.DataComponents;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.Equippable;
import net.shadowstorm7894.odinsdragons.item.armour.ModArmourMaterials;

public class FlightSuitItem extends Item {

    public FlightSuitItem(Properties properties) {
        super(properties.component(DataComponents.EQUIPPABLE, Equippable.builder(EquipmentSlot.CHEST)
                        .setAsset(ModArmourMaterials.WING_SUIT_MATERIAL)
                .build()).component(DataComponents.GLIDER, Unit.INSTANCE));
    }
}
