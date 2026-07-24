package net.shadowstorm7894.odinsdragons.client.model;


import com.geckolib.model.GeoModel;
import com.geckolib.renderer.base.GeoRenderState;
import net.minecraft.resources.Identifier;
import net.shadowstorm7894.odinsdragons.item.customitems.GliderItem;

public class GliderModel extends GeoModel<GliderItem> {
    @Override
    public Identifier getModelResource(GeoRenderState renderState) {
        return Identifier.fromNamespaceAndPath("odinsdragons", "glider");
    }

    @Override
    public Identifier getTextureResource(GeoRenderState renderState) {
        return Identifier.fromNamespaceAndPath("odinsdragons", "textures/item/gliderbasictexture.png");
    }

    @Override
    public Identifier getAnimationResource(GliderItem animatable) {
        return Identifier.fromNamespaceAndPath("odinsdragons", "glidertest");
    }
}