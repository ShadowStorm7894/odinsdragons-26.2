package net.shadowstorm7894.odinsdragons.datagen;

import net.minecraft.client.data.models.EquipmentAssetProvider;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.shadowstorm7894.odinsdragons.OdinsDragons;

import java.util.function.BiConsumer;

@EventBusSubscriber(modid = OdinsDragons.MOD_ID)
public class ModEquipmentAssetProvider extends EquipmentAssetProvider {
    public ModEquipmentAssetProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void registerModels(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> output){
       /* output.accept(ModArmourMaterials.WING_SUIT_MATERIAL,
                EquipmentClientInfo.builder()
                        .addLayers(EquipmentClientInfo.LayerType.WINGS,new EquipmentClientInfo.Layer(
                                                Identifier.fromNamespaceAndPath("odinsdragons","texture"),
                                                Optional.empty(), false)
                        )
                .build());*/
    }

    @SubscribeEvent // on the mod event bus
    public static void gatherData(GatherDataEvent.Client event) {
        event.createProvider(ModEquipmentAssetProvider::new);
    }
}
