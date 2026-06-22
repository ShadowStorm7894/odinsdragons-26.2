package net.shadowstorm7894.odinsdragons.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.shadowstorm7894.odinsdragons.OdinsDragons;
import net.shadowstorm7894.odinsdragons.item.customitems.FireSwordItem;
import net.shadowstorm7894.odinsdragons.item.customitems.FlightSuitItem;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(OdinsDragons.MOD_ID);

    public static final DeferredItem<Item> BOOK_OF_DRAGONS = ITEMS.register("book_of_dragons",
            registryname -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, registryname)))
    );

    public static final DeferredItem<Item> FIRE_SWORD = ITEMS.register("fire_sword",
            registryname -> new FireSwordItem(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, registryname))
                    .durability(4800))
    );
    public static final DeferredItem<Item> WING_SUIT = ITEMS.register("wing_suit",
            registername -> new FlightSuitItem(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, registername))
                    )
    );


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
