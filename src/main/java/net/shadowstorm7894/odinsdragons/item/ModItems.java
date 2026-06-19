package net.shadowstorm7894.odinsdragons.item;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.shadowstorm7894.odinsdragons.OdinsDragons;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(OdinsDragons.MOD_ID);

    public static final DeferredItem<Item> BOOKOFDRAGONS = ITEMS.register("book_of_dragons", registryname -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryname))));
    public static final DeferredItem<Item> FIRESWORD = ITEMS.register("fire_sword", registryname -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryname))));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
