package net.shadowstorm7894.odinsdragons.item.customitems;

import com.geckolib.animatable.GeoAnimatable;
import com.geckolib.animatable.GeoItem;
import com.geckolib.animatable.client.GeoRenderProvider;
import com.geckolib.animatable.instance.AnimatableInstanceCache;
import com.geckolib.animatable.manager.AnimatableManager;
import com.geckolib.animation.AnimationController;
import com.geckolib.animation.RawAnimation;
import com.geckolib.constant.DefaultAnimations;
import com.geckolib.constant.dataticket.DataTicket;
import com.geckolib.renderer.GeoArmorRenderer;
import com.geckolib.renderer.GeoItemRenderer;
import com.geckolib.util.GeckoLibUtil;
import com.google.common.base.Suppliers;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.Equippable;
import net.shadowstorm7894.odinsdragons.OdinsDragons;
import net.shadowstorm7894.odinsdragons.client.renderer.GliderRenderer;
import org.jspecify.annotations.Nullable;

import java.util.function.Consumer;
import java.util.function.Supplier;


public class GliderItem extends Item implements GeoItem {
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    public static final DataTicket<Boolean> GLIDING = DataTicket.create("odinsdragons_gliding", Boolean.class);
    public static boolean isGliding = false;

    public GliderItem(Properties properties) {
        super(properties.component(DataComponents.EQUIPPABLE, Equippable.builder(EquipmentSlot.CHEST).setAsset(ResourceKey.create(
                        EquipmentAssets.ROOT_ID,
                        Identifier.fromNamespaceAndPath(OdinsDragons.MOD_ID, "glider"))).build())
                .component(DataComponents.GLIDER, Unit.INSTANCE));
        GeoItem.registerSyncedAnimatable(this);
    }

    @Override
    public void registerControllers(final AnimatableManager.ControllerRegistrar controllers) {
        controllers.add( new AnimationController<>(test -> {
            boolean gliding = Boolean.TRUE.equals(test.getData(GLIDING));
            isGliding = !gliding;
            if (!gliding) {
                return test.setAndContinue(RawAnimation.begin().thenPlayAndHold("glidactive"));
            }
            return test.setAndContinue(DefaultAnimations.IDLE);
            }));
    }

    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer){
        consumer.accept(new GeoRenderProvider() {
            private final Supplier<GliderRenderer<?>> renderer = Suppliers.memoize(GliderRenderer::new);

            @Override
            public @Nullable GeoArmorRenderer<?, ?> getGeoArmorRenderer(ItemStack itemStack, EquipmentSlot equipmentSlot) {
                return this.renderer.get();
            }
        });
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.geoCache;
    }
}
