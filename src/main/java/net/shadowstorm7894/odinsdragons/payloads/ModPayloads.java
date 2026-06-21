package net.shadowstorm7894.odinsdragons.payloads;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handlers.ServerPayloadHandler;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.shadowstorm7894.odinsdragons.OdinsDragons;
import net.shadowstorm7894.odinsdragons.item.ModItems;
import net.shadowstorm7894.odinsdragons.item.datacomponents.ModDataComponents;

@EventBusSubscriber(modid = OdinsDragons.MOD_ID)
public class ModPayloads {
    @SubscribeEvent // on the mod event bus
    public static void register(RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar("1");
        registrar.playBidirectional(
                IGNITE_SWORD_DATA.TYPE,
                IGNITE_SWORD_DATA.STREAM_CODEC,
                ServerPayloadHandler::handleDataOnMain
        );
    }
    public class ClientPayloadHandler {
        public static void handleDataOnMain(final IGNITE_SWORD_DATA data, final IPayloadContext context) {
        }
    }
    public class ServerPayloadHandler {
        public static void handleDataOnMain(final IGNITE_SWORD_DATA data, final IPayloadContext context) {
            context.player().level().getServer().execute(() -> {
                ItemStack item = context.player().getMainHandItem();
                if (data.swordData){
                    item.set(ModDataComponents.LIT_STATE, true);
                } else {
                    item.remove(ModDataComponents.LIT_STATE);
                }

            });
        }
    }
    public record IGNITE_SWORD_DATA(Boolean swordData) implements CustomPacketPayload {

        public static final CustomPacketPayload.Type<IGNITE_SWORD_DATA> TYPE = new CustomPacketPayload.Type<>(Identifier.fromNamespaceAndPath("odinsdragons", "ignite_sword_data"));

        // Each pair of elements defines the stream codec of the element to encode/decode and the getter for the element to encode
        // 'name' will be encoded and decoded as a string
        // 'age' will be encoded and decoded as an integer
        // The final parameter takes in the previous parameters in the order they are provided to construct the payload object
        public static final StreamCodec<ByteBuf, IGNITE_SWORD_DATA> STREAM_CODEC = StreamCodec.composite(
                ByteBufCodecs.BOOL,
                IGNITE_SWORD_DATA::swordData,
                IGNITE_SWORD_DATA::new
        );

        @Override
        public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
            return TYPE;
        }
    }
}
