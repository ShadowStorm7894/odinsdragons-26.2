package net.shadowstorm7894.odinsdragons.item.armour;

import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.shadowstorm7894.odinsdragons.OdinsDragons;

public class ModArmourMaterials {
    public static final ResourceKey<? extends Registry<EquipmentAsset>> ROOT_ID = ResourceKey.createRegistryKey(Identifier.withDefaultNamespace("equipment_asset"));

    public static final ResourceKey<EquipmentAsset> WING_SUIT_MATERIAL = ResourceKey.create(ROOT_ID, Identifier.fromNamespaceAndPath(OdinsDragons.MOD_ID, "wing_suit"));

}
