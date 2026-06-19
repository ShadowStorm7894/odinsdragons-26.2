package net.shadowstorm7894.odinsdragons.datagen;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;
import net.neoforged.fml.common.Mod;
import net.shadowstorm7894.odinsdragons.OdinsDragons;
import net.shadowstorm7894.odinsdragons.item.ModItems;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, OdinsDragons.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels){
        itemModels.generateFlatItem(ModItems.BOOKOFDRAGONS.get(), ModelTemplates.FLAT_ITEM);
    }
}
