package net.shadowstorm7894.odinsdragons.item.datacomponents;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.select.SelectItemModelProperty;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.shadowstorm7894.odinsdragons.OdinsDragons;
import org.apache.commons.compress.archivers.dump.DumpArchiveEntry;
import org.jspecify.annotations.Nullable;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class ModDataComponents {
    public static final DeferredRegister.DataComponents DATA_COMPONENTS = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, OdinsDragons.MOD_ID);


    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> LIT_STATE = DATA_COMPONENTS.registerComponentType("lit_state",
      builder -> builder.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL)
    );
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> FUEL = DATA_COMPONENTS.registerComponentType("fuel",
            builder -> builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT)
    );
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> LIT_ANI_0 = DATA_COMPONENTS.registerComponentType("lit_ani_0",
            builder -> builder.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL)
    );
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> LIT_ANI_1 = DATA_COMPONENTS.registerComponentType("lit_ani_1",
            builder -> builder.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL)
    );
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> LIT_ANI_2 = DATA_COMPONENTS.registerComponentType("lit_ani_2",
            builder -> builder.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL)
    );
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> LIT_ANI_3 = DATA_COMPONENTS.registerComponentType("lit_ani_3",
            builder -> builder.persistent(Codec.BOOL).networkSynchronized(ByteBufCodecs.BOOL)
    );


    public static void register(IEventBus eventBus){
        DATA_COMPONENTS.register(eventBus);
    }
}
