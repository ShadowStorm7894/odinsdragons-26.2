package net.shadowstorm7894.odinsdragons.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import net.neoforged.neoforge.common.util.Lazy;
import net.shadowstorm7894.odinsdragons.OdinsDragons;
import org.lwjgl.glfw.GLFW;

@EventBusSubscriber(modid = OdinsDragons.MOD_ID,value = Dist.CLIENT)
public class KeymapHandler {
    public static final KeyMapping.Category ODINSDRAGONS_KEY_CATEGORY = new KeyMapping.Category(Identifier.fromNamespaceAndPath("odinsdragons", "category"));
    public static final String KEY_IGNITE_SWORD = "key.odinsdragons.ignite_sword";

    public static final Lazy<KeyMapping> IGNITE_KEY = Lazy.of(
            () -> new KeyMapping(
                    KEY_IGNITE_SWORD,
                    KeyConflictContext.IN_GAME,
                    InputConstants.Type.KEYSYM,
                    GLFW.GLFW_KEY_C,
                    ODINSDRAGONS_KEY_CATEGORY)
    );

    @SubscribeEvent
    public static void registerBindings(RegisterKeyMappingsEvent event) {
        event.registerCategory(ODINSDRAGONS_KEY_CATEGORY);
        event.register(IGNITE_KEY.get());
    }
}
