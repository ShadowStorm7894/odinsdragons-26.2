package net.shadowstorm7894.odinsdragons.client.renderer;

import com.geckolib.renderer.GeoArmorRenderer;
import com.geckolib.renderer.base.GeoRenderState;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.world.entity.LivingEntity;
import net.shadowstorm7894.odinsdragons.client.model.GliderModel;
import net.shadowstorm7894.odinsdragons.item.customitems.GliderItem;

public class GliderRenderer<R extends HumanoidRenderState & GeoRenderState> extends GeoArmorRenderer<GliderItem, R> {
    public GliderRenderer() {
        super(new GliderModel());
    }

    @Override
    public void addRenderData(GliderItem animatable, RenderData relatedObject, R renderState, float partialTick) {
        super.addRenderData(animatable, relatedObject, renderState, partialTick);
        boolean gliding = relatedObject.entity() instanceof LivingEntity le && le.isFallFlying();
        renderState.addGeckolibData(GliderItem.GLIDING, gliding);
    }
}
