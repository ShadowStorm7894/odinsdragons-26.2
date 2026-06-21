package net.shadowstorm7894.odinsdragons.item.datacomponents;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.shadowstorm7894.odinsdragons.OdinsDragons;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class ModDataComponents {
    public static final DeferredRegister.DataComponents DATA_COMPONENTS = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, OdinsDragons.MOD_ID);




    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> LIT_STATE = DATA_COMPONENTS.registerComponentType("lit_state",
      builder -> builder.persistent(Codec.BOOL)
    );

    public static void register(IEventBus eventBus){
        DATA_COMPONENTS.register(eventBus);
    }
}
