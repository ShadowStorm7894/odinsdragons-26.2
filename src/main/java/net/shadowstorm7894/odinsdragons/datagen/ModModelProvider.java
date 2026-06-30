package net.shadowstorm7894.odinsdragons.datagen;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.renderer.item.ClientItem;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.RangeSelectItemModel;
import net.minecraft.client.renderer.item.properties.numeric.Count;
import net.minecraft.client.renderer.item.properties.numeric.UseDuration;
import net.minecraft.client.renderer.item.properties.select.Charge;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.shadowstorm7894.odinsdragons.OdinsDragons;
import net.shadowstorm7894.odinsdragons.item.ModItems;
import net.shadowstorm7894.odinsdragons.item.datacomponents.ModDataComponents;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, OdinsDragons.MOD_ID);
    }


   public void generateFireSwordModel(ItemModelGenerators itemModel, DeferredItem<Item> item) {
        ItemModel.Unbaked unLitsword = ItemModelUtils.plainModel(itemModel.createFlatItemModel(item.get(), "",ModelTemplates.FLAT_ITEM));
        ItemModel.Unbaked litSword = ItemModelUtils.plainModel(itemModel.createFlatItemModel(item.get(), "_lit", ModelTemplates.FLAT_ITEM));
        itemModel.itemModelOutput.accept(
                item.get(),
                ItemModelUtils.conditional(ItemModelUtils.hasComponent(ModDataComponents.LIT_STATE.get()), litSword, unLitsword));
}

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels){
        itemModels.generateFlatItem(ModItems.BOOK_OF_DRAGONS.get(), ModelTemplates.FLAT_ITEM);
        generateFireSwordModel(itemModels, ModItems.FIRE_SWORD);
        itemModels.generateFlatItem(ModItems.WING_SUIT.get(), ModelTemplates.FLAT_ITEM);


        }
}
